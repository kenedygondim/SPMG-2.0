package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.CriarConvenioDto;
import com.project.sp_medical_group.Models.Convenio;
import com.project.sp_medical_group.Models.Endereco;

import java.util.List;

public interface ConvenioRepository {
    public abstract Convenio createConvenio(CriarConvenioDto criarConvenioDto);
    public abstract List<Convenio> getAllConvenios();
}
