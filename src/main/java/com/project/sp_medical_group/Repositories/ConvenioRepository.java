package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarConvenioDto;
import com.project.sp_medical_group.Models.Convenio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConvenioRepository {
    Convenio createConvenio (CriarConvenioDto criarConvenioDto);
    List<Convenio> getAllConvenios();
}
