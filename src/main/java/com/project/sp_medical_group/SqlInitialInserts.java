package com.project.sp_medical_group;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Mono;

@Configuration
public class SqlInitialInserts {

    @Bean
    CommandLineRunner checkDatabaseConnection(DatabaseClient databaseClient) {
        return args -> {
            databaseClient.sql("SELECT 1")
                .fetch()
                .rowsUpdated()
                .doOnSuccess(rows -> System.out.println("✅ Conexão com o banco de dados foi bem-sucedida!"))
                .doOnError(error -> {
                    System.err.println("❌ Falha ao conectar ao banco de dados!");
                    error.printStackTrace();
                })
                .subscribe();

            insertInitialData(databaseClient)
                .subscribe(
                    success -> System.out.println("✅ Dados iniciais inseridos no banco de dados com sucesso!"),
                    error -> {
                        System.err.println("❌ Falha ao inserir dados iniciais no banco de dados!");
                        error.printStackTrace();
                    }
                );
        };
    }

    private Mono<Void> insertInitialData(DatabaseClient databaseClient) {
        return Mono.when( 
            databaseClient.sql("INSERT INTO tb_convenios VALUES ('UNIMED')").fetch().rowsUpdated(),
            databaseClient.sql("INSERT INTO tb_convenios VALUES ('AMIL')").fetch().rowsUpdated(),
            databaseClient.sql("INSERT INTO tb_convenios VALUES ('BRADESCO')").fetch().rowsUpdated(),
            databaseClient.sql("INSERT INTO tb_convenios VALUES ('SULAMERICA')").fetch().rowsUpdated(),
            databaseClient.sql("INSERT INTO tb_convenios VALUES ('GOLDEN CROSS')").fetch().rowsUpdated()
        ).then();
    }
}
