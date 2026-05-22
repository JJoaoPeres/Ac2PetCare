package com.example.atividade4.services;

import java.util.List;

import com.example.atividade4.dtos.AnimalDTO;
import com.example.atividade4.dtos.InserirAnimalDTO;
import com.example.atividade4.models.Animal;

public interface AnimalService {

    Animal salvar(InserirAnimalDTO animalDTO);

    List<AnimalDTO> buscarTodos();

    AnimalDTO buscarPorId(Long id);

    List<AnimalDTO> buscarPorTutor(Long tutorId);

    List<AnimalDTO> buscarPorEspecie(String especie);
}