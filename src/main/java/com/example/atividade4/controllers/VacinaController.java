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

import com.example.atividade4.dtos.InserirVacinaDTO;
import com.example.atividade4.dtos.VacinaDTO;
import com.example.atividade4.models.Vacina;
import com.example.atividade4.services.VacinaService;

@RestController
@RequestMapping("/vacina")
public class VacinaController {

    @Autowired
    private VacinaService vacinaService;

    @GetMapping
    public List<VacinaDTO> obterTodos() {
        return vacinaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public VacinaDTO obterPorId(@PathVariable Long id) {
        return vacinaService.buscarPorId(id);
    }

    @GetMapping("/animal/{animalId}")
    public List<VacinaDTO> obterPorAnimal(@PathVariable Long animalId) {
        return vacinaService.buscarPorAnimal(animalId);
    }

    @GetMapping("/nome/{nome}")
    public List<VacinaDTO> obterPorNome(@PathVariable String nome) {
        return vacinaService.buscarPorNome(nome);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vacina salvar(@RequestBody InserirVacinaDTO vacinaDTO) {
        return vacinaService.salvar(vacinaDTO);
    }
}