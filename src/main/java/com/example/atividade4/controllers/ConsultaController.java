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

import com.example.atividade4.dtos.ConsultaDTO;
import com.example.atividade4.dtos.InserirConsultaDTO;
import com.example.atividade4.models.Consulta;
import com.example.atividade4.services.ConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public List<ConsultaDTO> obterTodos() {
        return consultaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ConsultaDTO obterPorId(@PathVariable Long id) {
        return consultaService.buscarPorId(id);
    }

    @GetMapping("/animal/{animalId}")
    public List<ConsultaDTO> obterPorAnimal(@PathVariable Long animalId) {
        return consultaService.buscarPorAnimal(animalId);
    }

    @GetMapping("/veterinario/{veterinarioId}")
    public List<ConsultaDTO> obterPorVeterinario(@PathVariable Long veterinarioId) {
        return consultaService.buscarPorVeterinario(veterinarioId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Consulta salvar(@RequestBody InserirConsultaDTO consultaDTO) {
        return consultaService.salvar(consultaDTO);
    }
}