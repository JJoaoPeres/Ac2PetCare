package com.example.atividade4.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atividade4.models.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByNomeLike(String nome);

    List<Animal> findByEspecie(String especie);

    List<Animal> findByTutorId(Long tutorId);
}