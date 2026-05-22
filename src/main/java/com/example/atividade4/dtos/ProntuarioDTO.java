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
public class ProntuarioDTO {

    private Long id;

    private LocalDate dataAtendimento;

    private String observacoes;

    private AnimalDTO animal;

    private VeterinarioDTO veterinario;
}