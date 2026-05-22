package com.example.atividade4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.atividade4.models.Informacao;

@Configuration
public class ConfiguracaoApp {

    @Bean
    public Informacao informacao() {
        return new Informacao(
                "Sistema PetCare Digital Solutions",
                1,
                "João Vitor Peres de Souza"
        );
    }

    @Bean
    public Float valorConsultaPadrao() {
        return 150F;
    }

    @Bean
    public Float valorVacinaPadrao() {
        return 80F;
    }
}