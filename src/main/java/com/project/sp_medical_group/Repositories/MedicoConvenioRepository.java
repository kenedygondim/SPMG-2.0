package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.AssociarMedicoConvenioDto;
import com.project.sp_medical_group.Models.MedicoConvenio;

public interface MedicoConvenioRepository {
    public abstract MedicoConvenio associateMedicoConvenio(AssociarMedicoConvenioDto associarMedicoConvenioDto);
}
