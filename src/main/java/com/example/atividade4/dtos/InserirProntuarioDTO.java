package com.example.atividade4.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InserirProntuarioDTO {

    private LocalDate dataAtendimento;

    private String observacoes;

    private Long animalId;

    private Long veterinarioId;
}