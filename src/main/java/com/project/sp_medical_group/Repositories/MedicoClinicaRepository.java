package com.project.sp_medical_group.Repositories;

import com.project.sp_medical_group.Dto.AssociarMedicoClinicaDto;
import com.project.sp_medical_group.Models.MedicoClinica;

public interface MedicoClinicaRepository {
    public abstract MedicoClinica associateMedicoClinica(AssociarMedicoClinicaDto associarMedicoClinicaDto);
}