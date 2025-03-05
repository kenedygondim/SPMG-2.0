package com.project.sp_medical_group.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.AgendarConsultaDto;
import com.project.sp_medical_group.Enum.SituacaoConsulta;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Models.Consulta;
import com.project.sp_medical_group.ReactiveCrudRepository.ConsultaReactiveCrudRepository;
import com.project.sp_medical_group.Repositories.ConsultaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ConsultaService implements ConsultaRepository {
    private final ConsultaReactiveCrudRepository consultaReactiveCrudRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public ConsultaService(ConsultaReactiveCrudRepository consultaReactiveCrudRepository, ObjectMapper objectMapper) {
        this.consultaReactiveCrudRepository = consultaReactiveCrudRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Mono<String> createConsulta(AgendarConsultaDto agendarConsultaDto) {
        //TO-DO implementar validação de horário e data (não permitir agendamento de consulta em data passada)
        //TO-DO implementar validação para não permitir consultas com médicos bloqueados pelo usuário
        //TO-DO implementar validação para não permitir agendamento de consultas em horários já ocupados
        return Mono.fromCallable(() -> { 
            Consulta consultaObj = objectMapper.convertValue(agendarConsultaDto, Consulta.class );
            consultaObj.setSituacao(SituacaoConsulta.AGENDADA);
            return consultaObj;
           })
           .flatMap(consultaReactiveCrudRepository::save)
           .thenReturn("Consulta agendada com sucesso!")
           .onErrorMap(Exception.class, e -> new BusinessException("Erro ao criar consulta"));
    }

    @Override
    public Flux<Consulta> getAllConsultasByPacienteCpf(String pacienteCpf) {
        return consultaReactiveCrudRepository.findAllByPacienteCpf(pacienteCpf);
    }  
}
