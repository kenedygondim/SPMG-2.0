package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Repositories.AvaliacaoMedicoRepository;
import com.project.sp_medical_group.Repositories.MedicoConvenioRepository;
import com.project.sp_medical_group.Repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spmg/medicos")
public class MedicoController {

    private final MedicoRepository medicoRepository;
    private final MedicoConvenioRepository medicoConvenioRepository;
    private final AvaliacaoMedicoRepository avaliacaoMedicoRepository;


    @Autowired
    public MedicoController(MedicoRepository medicoRepository, MedicoConvenioRepository medicoConvenioRepository, AvaliacaoMedicoRepository avaliacaoMedicoRepository) {
        this.medicoRepository = medicoRepository;
        this.medicoConvenioRepository = medicoConvenioRepository;
        this.avaliacaoMedicoRepository = avaliacaoMedicoRepository;
    }
}
