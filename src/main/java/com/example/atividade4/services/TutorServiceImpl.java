package com.example.atividade4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade4.dtos.InserirTutorDTO;
import com.example.atividade4.dtos.TutorDTO;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Tutor;
import com.example.atividade4.repositories.TutorRepository;

@Service
public class TutorServiceImpl implements TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public Tutor salvar(InserirTutorDTO tutorDTO) {

        Tutor tutor = Tutor.builder()
                .nome(tutorDTO.getNome())
                .cpf(tutorDTO.getCpf())
                .telefone(tutorDTO.getTelefone())
                .endereco(tutorDTO.getEndereco())
                .build();

        return tutorRepository.save(tutor);
    }

    @Override
    public List<TutorDTO> buscarTodos() {

        List<Tutor> tutores = tutorRepository.findAll();

        return tutores.stream().map((Tutor t) -> {
            return converterParaDTO(t);
        }).toList();
    }

    @Override
    public TutorDTO buscarPorId(Long id) {

        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Tutor não encontrado"));

        return converterParaDTO(tutor);
    }

    @Override
    public TutorDTO buscarPorCpf(String cpf) {

        Tutor tutor = tutorRepository.findByCpf(cpf)
                .orElseThrow(() -> new RegraNegocioException("Tutor não encontrado"));

        return converterParaDTO(tutor);
    }

    @Override
    public List<TutorDTO> buscarPorNome(String nome) {

        List<Tutor> tutores = tutorRepository.findByNomeLike(nome);

        return tutores.stream().map((Tutor t) -> {
            return converterParaDTO(t);
        }).toList();
    }

    private TutorDTO converterParaDTO(Tutor tutor) {

        return TutorDTO.builder()
                .id(tutor.getId())
                .nome(tutor.getNome())
                .cpf(tutor.getCpf())
                .telefone(tutor.getTelefone())
                .endereco(tutor.getEndereco())
                .build();
    }
}