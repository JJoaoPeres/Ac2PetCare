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

import com.example.atividade4.dtos.InserirProntuarioDTO;
import com.example.atividade4.dtos.ProntuarioDTO;
import com.example.atividade4.models.Prontuario;
import com.example.atividade4.services.ProntuarioService;

@RestController
@RequestMapping("/prontuario")
public class ProntuarioController {

    @Autowired
    private ProntuarioService prontuarioService;

    @GetMapping
    public List<ProntuarioDTO> obterTodos() {
        return prontuarioService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ProntuarioDTO obterPorId(@PathVariable Long id) {
        return prontuarioService.buscarPorId(id);
    }

    @GetMapping("/animal/{animalId}")
    public List<ProntuarioDTO> obterPorAnimal(@PathVariable Long animalId) {
        return prontuarioService.buscarPorAnimal(animalId);
    }

    @GetMapping("/veterinario/{veterinarioId}")
    public List<ProntuarioDTO> obterPorVeterinario(@PathVariable Long veterinarioId) {
        return prontuarioService.buscarPorVeterinario(veterinarioId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prontuario salvar(@RequestBody InserirProntuarioDTO prontuarioDTO) {
        return prontuarioService.salvar(prontuarioDTO);
    }
}