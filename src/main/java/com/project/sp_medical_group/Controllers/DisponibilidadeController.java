package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Repositories.DisponibilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("spmg/disponibilidades")
public class DisponibilidadeController {
    private final DisponibilidadeRepository disponibilidadeRepository;

    @Autowired
    public DisponibilidadeController(DisponibilidadeRepository disponibilidadeRepository) {
        this.disponibilidadeRepository = disponibilidadeRepository;
    }
}
