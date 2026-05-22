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
public class AnimalDTO {

    private Long id;

    private String nome;

    private String especie;

    private String raca;

    private LocalDate dataNascimento;

    private TutorDTO tutor;
}