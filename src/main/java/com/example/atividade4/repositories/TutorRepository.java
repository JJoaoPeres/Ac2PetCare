package com.example.atividade4.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atividade4.models.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    List<Tutor> findByNomeLike(String nome);

    Optional<Tutor> findByCpf(String cpf);

    List<Tutor> findByTelefone(String telefone);
}