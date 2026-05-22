package com.example.atividade4.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InserirTutorDTO {

    private String nome;

    private String cpf;

    private String telefone;

    private String endereco;
}