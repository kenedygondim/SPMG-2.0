package com.project.sp_medical_group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SqlInitialInserts{
    @Bean
    CommandLineRunner checkDatabaseConnection(JdbcTemplate jdbcTemplate) {
        return args -> {
            try {
                jdbcTemplate.execute("SELECT 1");
                System.out.println("✅ Conexão com o banco de dados foi bem-sucedida!");
            } catch (Exception e) {
                System.err.println("❌ Falha ao conectar ao banco de dados!");
                e.printStackTrace();
            }

            try {
                jdbcTemplate.execute("INSERT INTO tb_roles VALUES ('ADMIN')");
                jdbcTemplate.execute("INSERT INTO tb_roles VALUES ('MEDICO')");
                jdbcTemplate.execute("INSERT INTO tb_roles VALUES ('PACIENTE')");

                System.out.println("✅ Dados iniciais inseridos no banco de dados com sucesso!");
            }
            catch (Exception e) {
                System.err.println("❌ Falha ao inserir dados iniciais no banco de dados!");
                e.printStackTrace();
            }
        };
    }
}
