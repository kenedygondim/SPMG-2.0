package com.project.sp_medical_group.Services.OpenAI;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.MedicosDetalhesDto;
import com.project.sp_medical_group.Models.Especialidade;
import com.project.sp_medical_group.Repositories.EspecialidadeRepository;
import com.project.sp_medical_group.Repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChatGPTAPIService {
    @Value("${openai.api.key}")
    private String apiKey;
    private final ObjectMapper mapper;
    private final MedicoRepository medicoRepository;
    private final EspecialidadeRepository especialidadeRepository;

    @Autowired
    public ChatGPTAPIService(MedicoRepository medicoRepository, ObjectMapper mapper, EspecialidadeRepository especialidadeRepository) {
        this.medicoRepository = medicoRepository;
        this.mapper = mapper;
        this.especialidadeRepository = especialidadeRepository;
    }

    public String chat(String prompt) throws Exception {

        Map<String, Object> funcaoBuscarMedicos = this.loadFunction("buscar_medicos.json");
        Map<String, Object> funcaoBuscarClinicas = this.loadFunction("buscar_clinicas.json"); // TODO: Implementar a função buscar_clinicas.json


        String instrucoesEssenciais = Files.readString(Paths.get("src/main/resources/openai/prompts/ajuda_identificar_especialidades.txt"));

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4.1-mini",
                "temperature", 0.7,
                "max_tokens", 100,
                "top_p", 1,
                "frequency_penalty", 0.0,
                "presence_penalty", 0.6,
                "messages", List.of(
                        Map.of("role", "system", "content", instrucoesEssenciais),
                        Map.of("role", "user", "content", prompt)
                ),
                "functions", List.of(funcaoBuscarMedicos, funcaoBuscarClinicas),
                "function_call", "auto"
        );

        System.out.println("\n2 - Requisição para OpenAI: " + requestBody);

        String response = sendToOpenAI(requestBody);

        System.out.println("\n3 - Resposta da OpenAI: " + response);

        Map<String, Object> parsed = mapper.readValue(response, new TypeReference<>() {});

        List<Map<String, Object>> choices = (List<Map<String, Object>>) parsed.get("choices");
        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");



        if (message.containsKey("function_call")) {
            Map<String, Object> functionCall = (Map<String, Object>) message.get("function_call");
            String nomeFuncao = (String) functionCall.get("name");
            String argsJson = (String) functionCall.get("arguments");
            Map<String, String> argumentos = mapper.readValue(argsJson, new TypeReference<>() {});

            BigDecimal valorConsulta = null;

            if("buscar_medicos".equals(nomeFuncao)) {
                try {
                    valorConsulta = new BigDecimal(argumentos.get("valor_consulta"));
                } catch (NumberFormatException e) {
                    System.out.println("Erro ao converter valor da consulta: " + e.getMessage());
                }

                List<MedicosDetalhesDto> medicos = medicoRepository.getMedicoDetalhes(argumentos.get("convenio"), argumentos.get("especialidade"), valorConsulta);

                if (medicos.isEmpty()) {
                    return "Não encontramos médicos disponíveis com os parâmetros fornecidos. Você pode tentar novamente com outros parâmetros ou realizar uma consulta avançada na sessão de filtros.";
                }

                String respostaIA = sendToOpenAI((Map.of(
                        "model", "gpt-4.1-mini",
                        "messages", List.of(
                                Map.of("role", "user", "content", this.buildPrompt(prompt)),
                                Map.of("role", "function", "name", nomeFuncao, "content", mapper.writeValueAsString(medicos))
                        )
                )));

                Map<String, Object> respostaFinal = mapper.readValue(respostaIA, new TypeReference<>() {});
                Map<String, Object> mensagemFinal = (Map<String, Object>) ((List<?>) respostaFinal.get("choices")).get(0);
                return ((Map<?, ?>) mensagemFinal.get("message")).get("content").toString();

            }
            else {
                System.out.println("A função chamada não é a buscar_medicos.");
            }
        }

        return message.get("content").toString();
    }

    private Map<String, Object> loadFunction(String nomeArquivo) throws IOException {
        InputStream input = getClass().getClassLoader().getResourceAsStream("openai/functions/" + nomeArquivo);
        return mapper.readValue(input, new TypeReference<>() {});
    }

    private String sendToOpenAI(Map<String, Object> payload) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+ apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(payload)))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private String buildPrompt(String prompt) throws IOException {
        try {
            String content = Files.readString(Paths.get("src/main/resources/openai/prompts/ajuda_identificar_especialidades.txt"));
            String especialidades = especialidadeRepository.getAllEspecialidades().toString();
            content = content.replace("{especialidades}", especialidades).replace("{prompt}", prompt);

            System.out.println(content);

            return content;
        } catch (IOException e) {
            throw new IOException("Erro ao ler o arquivo de prompt: " + e.getMessage());
        }
    }

}
