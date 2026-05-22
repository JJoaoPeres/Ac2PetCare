package com.example.atividade4.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Informacao {

    private String nomeSistema;

    private Integer versao;

    private String autor;
}