package com.project.sp_medical_group.Services.Core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.CriarEspecialidadeDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Jpa.Repositories.EspecialidadeJpaRepository;
import com.project.sp_medical_group.Models.Especialidade;
import com.project.sp_medical_group.Repositories.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeService implements EspecialidadeRepository {
    private final ObjectMapper objectMapper;
    private final EspecialidadeJpaRepository especialidadeJpaRepository;

    @Autowired
    public EspecialidadeService(ObjectMapper objectMapper, EspecialidadeJpaRepository especialidadeJpaRepository) {
        this.objectMapper = objectMapper;
        this.especialidadeJpaRepository = especialidadeJpaRepository;
    }

    @Override
    public Especialidade createEspecialidade(CriarEspecialidadeDto criarEspecialidadeDto) {
        try {
            Especialidade especialidade = objectMapper.convertValue(criarEspecialidadeDto, Especialidade.class);
            return especialidadeJpaRepository.save(especialidade);
        } catch (IllegalArgumentException e) {
            throw new BusinessException("Argumento inválido para conversão de Dto para Classe: " + e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException("Já existe uma especialidade cadastrada com esse nome: " + e.getMessage());
        } catch (Exception e) {
            throw new BusinessException("Erro ao criar especialidade: " + e.getMessage());
        }
    }

    @Override
    public List<Especialidade> getAllEspecialidades() {
        return especialidadeJpaRepository.findAll();
    }
}
