package com.example.atividade4.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String crmv;

    private String especializacao;

    @OneToMany(mappedBy = "veterinario")
    @JsonIgnore
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "veterinario")
    @JsonIgnore
    private List<Prontuario> prontuarios;
}