package com.example.atividade4.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacinaDTO {

    private Long id;

    private String nome;

    private LocalDate dataAplicacao;

    private LocalDate dataProximaDose;

    private String observacoes;

    private AnimalDTO animal;
}