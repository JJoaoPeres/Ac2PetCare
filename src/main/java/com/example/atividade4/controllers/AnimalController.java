package com.example.atividade4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.atividade4.dtos.AnimalDTO;
import com.example.atividade4.dtos.InserirAnimalDTO;
import com.example.atividade4.models.Animal;
import com.example.atividade4.services.AnimalService;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<AnimalDTO> obterTodos() {
        return animalService.buscarTodos();
    }

    @GetMapping("/{id}")
    public AnimalDTO obterPorId(@PathVariable Long id) {
        return animalService.buscarPorId(id);
    }

    @GetMapping("/tutor/{tutorId}")
    public List<AnimalDTO> obterPorTutor(@PathVariable Long tutorId) {
        return animalService.buscarPorTutor(tutorId);
    }

    @GetMapping("/especie/{especie}")
    public List<AnimalDTO> obterPorEspecie(@PathVariable String especie) {
        return animalService.buscarPorEspecie(especie);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Animal salvar(@RequestBody InserirAnimalDTO animalDTO) {
        return animalService.salvar(animalDTO);
    }
}