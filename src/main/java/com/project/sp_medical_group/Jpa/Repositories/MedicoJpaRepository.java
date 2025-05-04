package com.project.sp_medical_group.Jpa.Repositories;

import com.project.sp_medical_group.Dto.MedicosDetalhesDto;
import com.project.sp_medical_group.Models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface MedicoJpaRepository extends JpaRepository<Medico, Long> {
    @Query(value = "EXEC PRCDR_busca_medicos_function_calling :convenio_nome, :especialidade_nome, :preco_consulta",
            nativeQuery = true)
    List<MedicosDetalhesDto> getMedicoDetalhes(
            @Param("convenio_nome") String convenioNome,
            @Param("especialidade_nome") String especialidadeNome,
            @Param("preco_consulta") BigDecimal precoConsulta)
            ;
}
