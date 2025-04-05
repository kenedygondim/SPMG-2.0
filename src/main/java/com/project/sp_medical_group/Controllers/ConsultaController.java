package com.project.sp_medical_group.Controllers;

import com.project.sp_medical_group.Repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spmg/consultas")
public class ConsultaController {
    private final ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaController(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }
}
