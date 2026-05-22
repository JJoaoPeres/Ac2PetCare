package com.example.atividade4.services;

import java.util.List;

import com.example.atividade4.dtos.InserirVeterinarioDTO;
import com.example.atividade4.dtos.VeterinarioDTO;
import com.example.atividade4.models.Veterinario;

public interface VeterinarioService {

    Veterinario salvar(InserirVeterinarioDTO veterinarioDTO);

    List<VeterinarioDTO> buscarTodos();

    VeterinarioDTO buscarPorId(Long id);

    VeterinarioDTO buscarPorCrmv(String crmv);

    List<VeterinarioDTO> buscarPorNome(String nome);

    List<VeterinarioDTO> buscarPorEspecializacao(String especializacao);
}