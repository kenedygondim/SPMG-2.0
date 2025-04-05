package com.project.sp_medical_group.Services.Core;

import com.project.sp_medical_group.Dto.AssociarMedicoConvenioDto;
import com.project.sp_medical_group.Models.MedicoConvenio;
import com.project.sp_medical_group.Repositories.MedicoClinicaRepository;
import com.project.sp_medical_group.Repositories.MedicoConvenioRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicoConvenioService implements MedicoConvenioRepository {
    @Override
    public MedicoConvenio associateMedicoConvenio(AssociarMedicoConvenioDto associarMedicoConvenioDto) {
        return null;
    }
}
