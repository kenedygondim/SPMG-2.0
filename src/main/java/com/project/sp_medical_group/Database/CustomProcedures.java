package com.project.sp_medical_group.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public class CustomProcedures {
    private final DatabaseClient databaseClient;

    @Autowired
    public CustomProcedures(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

        public Mono<Integer> checaNumeroConsultasPacienteClinica(String clinicaCnpj, String pacienteCpf) {
        String sql = "EXEC PRCDR_checa_consultas_do_paciente_na_clinica :clinica_cnpj, :paciente_cpf";
        return databaseClient.sql(sql)
                .bind("clinica_cnpj", clinicaCnpj)
                .bind("paciente_cpf", pacienteCpf)
                .fetch()
                .first() // Pega a primeira linha do resultado
                .map(row -> (Integer) row.get("NUMERO_DE_CONSULTAS")); // Mapeia o valor da coluna "count" para Integer
        }

        public Mono<Integer> checaNumeroConsultasPacienteMedico(String medicoCpf, String pacienteCpf) {
            String sql = "EXEC PRCDR_checa_consultas_do_paciente_com_o_medico :medico_cpf, :paciente_cpf";
            return databaseClient.sql(sql)
                    .bind("medico_cpf", medicoCpf)
                    .bind("paciente_cpf", pacienteCpf)
                    .fetch()
                    .first() // Pega a primeira linha do resultado
                    .map(row -> (Integer) row.get("NUMERO_DE_CONSULTAS")); // Mapeia o valor da coluna "count" para Integer
            }
}
