package com.example.atividade4.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atividade4.models.Prontuario;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {

    List<Prontuario> findByAnimalId(Long animalId);

    List<Prontuario> findByVeterinarioId(Long veterinarioId);

    List<Prontuario> findByDataAtendimento(LocalDate dataAtendimento);
}