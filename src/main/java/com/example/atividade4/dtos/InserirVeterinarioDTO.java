package com.example.atividade4.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InserirVeterinarioDTO {

    private String nome;

    private String crmv;

    private String especializacao;
}