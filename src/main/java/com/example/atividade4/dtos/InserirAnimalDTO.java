package com.example.atividade4.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InserirAnimalDTO {

    private String nome;

    private String especie;

    private String raca;

    private LocalDate dataNascimento;

    private Long tutorId;
}