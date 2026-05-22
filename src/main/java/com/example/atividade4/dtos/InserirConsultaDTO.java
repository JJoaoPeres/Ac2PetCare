package com.example.atividade4.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InserirConsultaDTO {

    private String local;

    private LocalDate data;

    private LocalTime hora;

    private Long animalId;

    private Long veterinarioId;
}