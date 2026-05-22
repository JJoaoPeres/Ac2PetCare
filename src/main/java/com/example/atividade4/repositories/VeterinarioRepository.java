package com.example.atividade4.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atividade4.models.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {

    List<Veterinario> findByNomeLike(String nome);

    Optional<Veterinario> findByCrmv(String crmv);

    List<Veterinario> findByEspecializacao(String especializacao);
}