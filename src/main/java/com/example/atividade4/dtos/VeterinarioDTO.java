package com.example.atividade4.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeterinarioDTO {

    private Long id;

    private String nome;

    private String crmv;

    private String especializacao;
}