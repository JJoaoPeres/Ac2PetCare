package com.example.atividade4.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InserirVacinaDTO {

    private String nome;

    private LocalDate dataAplicacao;

    private LocalDate dataProximaDose;

    private String observacoes;

    private Long animalId;
}