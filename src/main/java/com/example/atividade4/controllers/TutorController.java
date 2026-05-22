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

import com.example.atividade4.dtos.InserirTutorDTO;
import com.example.atividade4.dtos.TutorDTO;
import com.example.atividade4.models.Tutor;
import com.example.atividade4.services.TutorService;

@RestController
@RequestMapping("/tutor")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping
    public List<TutorDTO> obterTodos() {
        return tutorService.buscarTodos();
    }

    @GetMapping("/{id}")
    public TutorDTO obterPorId(@PathVariable Long id) {
        return tutorService.buscarPorId(id);
    }

    @GetMapping("/cpf/{cpf}")
    public TutorDTO obterPorCpf(@PathVariable String cpf) {
        return tutorService.buscarPorCpf(cpf);
    }

    @GetMapping("/nome/{nome}")
    public List<TutorDTO> obterPorNome(@PathVariable String nome) {
        return tutorService.buscarPorNome(nome);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tutor salvar(@RequestBody InserirTutorDTO tutorDTO) {
        return tutorService.salvar(tutorDTO);
    }
}