package com.example.atividade4.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atividade4.models.Vacina;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {

    List<Vacina> findByAnimalId(Long animalId);

    List<Vacina> findByNomeLike(String nome);

    List<Vacina> findByDataAplicacao(LocalDate dataAplicacao);

    List<Vacina> findByDataProximaDose(LocalDate dataProximaDose);
}