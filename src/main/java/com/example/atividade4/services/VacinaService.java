package com.example.atividade4.services;

import java.util.List;

import com.example.atividade4.dtos.InserirVacinaDTO;
import com.example.atividade4.dtos.VacinaDTO;
import com.example.atividade4.models.Vacina;

public interface VacinaService {

    Vacina salvar(InserirVacinaDTO vacinaDTO);

    List<VacinaDTO> buscarTodos();

    VacinaDTO buscarPorId(Long id);

    List<VacinaDTO> buscarPorAnimal(Long animalId);

    List<VacinaDTO> buscarPorNome(String nome);
}