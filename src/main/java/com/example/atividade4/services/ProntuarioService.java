package com.example.atividade4.services;

import java.util.List;

import com.example.atividade4.dtos.InserirProntuarioDTO;
import com.example.atividade4.dtos.ProntuarioDTO;
import com.example.atividade4.models.Prontuario;

public interface ProntuarioService {

    Prontuario salvar(InserirProntuarioDTO prontuarioDTO);

    List<ProntuarioDTO> buscarTodos();

    ProntuarioDTO buscarPorId(Long id);

    List<ProntuarioDTO> buscarPorAnimal(Long animalId);

    List<ProntuarioDTO> buscarPorVeterinario(Long veterinarioId);
}