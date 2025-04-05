package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Repositories.EspecialidadeRepository;
import com.project.sp_medical_group.Repositories.MedicoEspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spmg/especialidades")
public class EspecialidadeController {
    private final EspecialidadeRepository especialidadeRepository;
    private final MedicoEspecialidadeRepository medicoEspecialidadeRepository;

    @Autowired
    public EspecialidadeController(EspecialidadeRepository especialidadeRepository, MedicoEspecialidadeRepository medicoEspecialidadeRepository) {
        this.especialidadeRepository = especialidadeRepository;
        this.medicoEspecialidadeRepository = medicoEspecialidadeRepository;
    }
}
