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

import com.example.atividade4.dtos.InserirVeterinarioDTO;
import com.example.atividade4.dtos.VeterinarioDTO;
import com.example.atividade4.models.Veterinario;
import com.example.atividade4.services.VeterinarioService;

@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping
    public List<VeterinarioDTO> obterTodos() {
        return veterinarioService.buscarTodos();
    }

    @GetMapping("/{id}")
    public VeterinarioDTO obterPorId(@PathVariable Long id) {
        return veterinarioService.buscarPorId(id);
    }

    @GetMapping("/crmv/{crmv}")
    public VeterinarioDTO obterPorCrmv(@PathVariable String crmv) {
        return veterinarioService.buscarPorCrmv(crmv);
    }

    @GetMapping("/nome/{nome}")
    public List<VeterinarioDTO> obterPorNome(@PathVariable String nome) {
        return veterinarioService.buscarPorNome(nome);
    }

    @GetMapping("/especializacao/{especializacao}")
    public List<VeterinarioDTO> obterPorEspecializacao(@PathVariable String especializacao) {
        return veterinarioService.buscarPorEspecializacao(especializacao);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veterinario salvar(@RequestBody InserirVeterinarioDTO veterinarioDTO) {
        return veterinarioService.salvar(veterinarioDTO);
    }
}