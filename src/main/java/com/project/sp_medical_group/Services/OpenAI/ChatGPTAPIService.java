package com.project.sp_medical_group.Services.OpenAI;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.MedicosDetalhesDto;
import com.project.sp_medical_group.Repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

@Service
public class ChatGPTAPIService {
    @Value("${openai.api.key}")
    private String apiKey;
    private final ObjectMapper mapper;
    private final MedicoRepository medicoRepository;

    @Autowired
    public ChatGPTAPIService(MedicoRepository medicoRepository, ObjectMapper mapper) {
        this.medicoRepository = medicoRepository;
        this.mapper = mapper;
    }

    public String chat(String prompt) throws Exception {

        Map<String, Object> funcaoBuscarMedicos = this.loadFunction("buscar_medicos.json");

        System.out.println("\n1 - Função buscar médicos carregada: " + funcaoBuscarMedicos);

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4.1-mini",
                "temperature", 0.7,
                "max_tokens", 100,
                "top_p", 1,
                "frequency_penalty", 0.0,
                "presence_penalty", 0.6,
                "messages", List.of(
                        Map.of("role", "system", "content", "Você é um assistente virtual empático, gentil e altamente educado, que atua em uma plataforma que conecta pacientes a médicos. Sempre responda com empatia, cordialidade e profissionalismo, mesmo que o paciente seja rude ou agressivo. Use uma linguagem acessível, clara e acolhedora. Jamais ofereça diagnósticos definitivos e sempre deixe claro que a triagem inicial feita por você é apenas uma sugestão e não substitui uma consulta com um médico de verdade. Diga isso de forma suave, sem alarmar o paciente. Adapte o nível de detalhamento de acordo com o que o usuário parece precisar. Quando for solicitado, explique os termos médicos de forma simples. Quando o paciente estiver indeciso sobre qual médico procurar, ajude a identificar a especialidade ideal com base nos sintomas informados. Ao sugerir médicos, leve em consideração os seguintes critérios, se disponíveis: - Especialidade médica - Localização da consulta - Se aceita convênio (e quais) - Número de estrelas recebidas - Número de consultas realizadas - Preço da consulta. Se o paciente não fornecer informações suficientes, faça perguntas educadas para completar a triagem. Nunca faça suposições perigosas ou que possam causar confusão. Seja sempre prestativo, paciente e focado em ajudar da melhor forma possível. Sempre seja claro e use poucas frases ao responder o paciente. Somente responda perguntas relacionadas ao contexto saúde/medicina."),
                        Map.of("role", "user", "content", prompt)
                ),
                "functions", List.of(funcaoBuscarMedicos),
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

            System.out.println("Parametro 1: " + argumentos.get("convenio"));
            System.out.println("Parametro 2: " + argumentos.get("especialidade"));


            // Chama a função real
            List<MedicosDetalhesDto> medicos = medicoRepository.getMedicoDetalhes(argumentos.get("convenio"), argumentos.get("especialidade"));

            System.out.println("\n4 - Médicos encontrados: " + medicos);


            if (medicos.isEmpty()) {
                return "Desculpe, não encontramos médicos disponíveis com os parâmetros fornecidos.";
            }


            // Envia a resposta da função de volta para a IA
            String respostaIA = sendToOpenAI((Map.of(
                    "model", "gpt-4.1-mini",
                    "messages", List.of(
                            Map.of("role", "user", "content", prompt),
                            Map.of("role", "function", "name", nomeFuncao, "content", mapper.writeValueAsString(medicos))
                    )
            )));

            System.out.println("\n5 - Resposta da IA após chamada de função: " + respostaIA);

            Map<String, Object> respostaFinal = mapper.readValue(respostaIA, new TypeReference<>() {});
            Map<String, Object> mensagemFinal = (Map<String, Object>) ((List<?>) respostaFinal.get("choices")).get(0);
            return ((Map<?, ?>) mensagemFinal.get("message")).get("content").toString();
        }

        // Caso a IA tenha respondido sem function_call
        return message.get("content").toString();
    }

    public Map<String, Object> loadFunction(String nomeArquivo) throws IOException {
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


}
