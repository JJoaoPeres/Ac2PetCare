package com.example.atividade4.services;

import java.util.List;

import com.example.atividade4.dtos.InserirTutorDTO;
import com.example.atividade4.dtos.TutorDTO;
import com.example.atividade4.models.Tutor;

public interface TutorService {

    Tutor salvar(InserirTutorDTO tutorDTO);

    List<TutorDTO> buscarTodos();

    TutorDTO buscarPorId(Long id);

    TutorDTO buscarPorCpf(String cpf);

    List<TutorDTO> buscarPorNome(String nome);
}