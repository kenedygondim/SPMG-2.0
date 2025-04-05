package com.project.sp_medical_group.Services.Core;

import com.project.sp_medical_group.Dto.AssociarMedicoClinicaDto;
import com.project.sp_medical_group.Models.MedicoClinica;
import com.project.sp_medical_group.Repositories.MedicoClinicaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MedicoClinicaService implements MedicoClinicaRepository {
    @Override
    public MedicoClinica associateMedicoClinica(AssociarMedicoClinicaDto associarMedicoClinicaDto) {
        return null;
    }
}
