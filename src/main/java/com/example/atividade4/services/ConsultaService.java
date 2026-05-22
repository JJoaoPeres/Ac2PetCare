package com.example.atividade4.services;

import java.util.List;

import com.example.atividade4.dtos.ConsultaDTO;
import com.example.atividade4.dtos.InserirConsultaDTO;
import com.example.atividade4.models.Consulta;

public interface ConsultaService {

    Consulta salvar(InserirConsultaDTO consultaDTO);

    List<ConsultaDTO> buscarTodos();

    ConsultaDTO buscarPorId(Long id);

    List<ConsultaDTO> buscarPorAnimal(Long animalId);

    List<ConsultaDTO> buscarPorVeterinario(Long veterinarioId);
}