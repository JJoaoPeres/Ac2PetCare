package com.example.atividade4.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaDTO {

    private Long id;

    private String local;

    private LocalDate data;

    private LocalTime hora;

    private AnimalDTO animal;

    private VeterinarioDTO veterinario;
}