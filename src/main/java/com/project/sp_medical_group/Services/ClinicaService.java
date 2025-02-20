package com.project.sp_medical_group.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sp_medical_group.Dto.CriarClinicaComEnderecoDto;
import com.project.sp_medical_group.Dto.CriarClinicaDto;
import com.project.sp_medical_group.Handler.BusinessException;
import com.project.sp_medical_group.Jpa.Repositories.ClinicaJpaRepository;
import com.project.sp_medical_group.Models.Clinica;
import com.project.sp_medical_group.Models.Convenio;
import com.project.sp_medical_group.Models.Endereco;
import com.project.sp_medical_group.Repositories.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicaService implements ClinicaRepository {
    private final ClinicaJpaRepository clinicaJpaRepository;
    private final EnderecoService enderecoService;

    @Autowired
    public ClinicaService(ClinicaJpaRepository clinicaJpaRepository, EnderecoService enderecoService) {
        this.clinicaJpaRepository = clinicaJpaRepository;
        this.enderecoService = enderecoService;
    }

    @Override
    public List<Clinica> getAllClinicas() {
        return clinicaJpaRepository.findAll();
    }

    @Override
    public Clinica createClinica(CriarClinicaComEnderecoDto criarClinicaComEnderecoDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Clinica clinica = objectMapper.convertValue(criarClinicaComEnderecoDto.clinica(), Clinica.class);
            Endereco endereco = enderecoService.createEndereco(criarClinicaComEnderecoDto.endereco());
            clinica.setEndereco(endereco);
            return clinicaJpaRepository.save(clinica);
        }
        catch (IllegalArgumentException e) {
            throw new BusinessException("Argumento inválido para conversão de Dto para Classe: " + e.getMessage());
        }
        catch (DataIntegrityViolationException e) {
            throw new BusinessException("Já existe uma clínica cadastrado com essa razão social ou nome fantasia: " + e.getMessage());
        }
    }

}
