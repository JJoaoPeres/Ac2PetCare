package com.example.atividade4.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atividade4.models.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    List<Consulta> findByAnimalId(Long animalId);

    List<Consulta> findByVeterinarioId(Long veterinarioId);

    List<Consulta> findByData(LocalDate data);

    boolean existsByVeterinarioIdAndDataAndHora(Long veterinarioId, LocalDate data, LocalTime hora);
}