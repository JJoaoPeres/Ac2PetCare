package com.example.atividade4.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TutorDTO {

    private Long id;

    private String nome;

    private String cpf;

    private String telefone;

    private String endereco;
}