package com.example.atividade4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade4.dtos.AnimalDTO;
import com.example.atividade4.dtos.InserirProntuarioDTO;
import com.example.atividade4.dtos.ProntuarioDTO;
import com.example.atividade4.dtos.TutorDTO;
import com.example.atividade4.dtos.VeterinarioDTO;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Animal;
import com.example.atividade4.models.Prontuario;
import com.example.atividade4.models.Veterinario;
import com.example.atividade4.repositories.AnimalRepository;
import com.example.atividade4.repositories.ProntuarioRepository;
import com.example.atividade4.repositories.VeterinarioRepository;

@Service
public class ProntuarioServiceImpl implements ProntuarioService {

    @Autowired
    private ProntuarioRepository prontuarioRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Override
    public Prontuario salvar(InserirProntuarioDTO prontuarioDTO) {

        Animal animal = animalRepository.findById(prontuarioDTO.getAnimalId())
                .orElseThrow(() -> new RegraNegocioException("Animal não encontrado"));

        Veterinario veterinario = veterinarioRepository.findById(prontuarioDTO.getVeterinarioId())
                .orElseThrow(() -> new RegraNegocioException("Veterinário não encontrado"));

        Prontuario prontuario = Prontuario.builder()
                .dataAtendimento(prontuarioDTO.getDataAtendimento())
                .observacoes(prontuarioDTO.getObservacoes())
                .animal(animal)
                .veterinario(veterinario)
                .build();

        return prontuarioRepository.save(prontuario);
    }

    @Override
    public List<ProntuarioDTO> buscarTodos() {

        List<Prontuario> prontuarios = prontuarioRepository.findAll();

        return prontuarios.stream().map((Prontuario p) -> {
            return converterParaDTO(p);
        }).toList();
    }

    @Override
    public ProntuarioDTO buscarPorId(Long id) {

        Prontuario prontuario = prontuarioRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Prontuário não encontrado"));

        return converterParaDTO(prontuario);
    }

    @Override
    public List<ProntuarioDTO> buscarPorAnimal(Long animalId) {

        List<Prontuario> prontuarios = prontuarioRepository.findByAnimalId(animalId);

        return prontuarios.stream().map((Prontuario p) -> {
            return converterParaDTO(p);
        }).toList();
    }

    @Override
    public List<ProntuarioDTO> buscarPorVeterinario(Long veterinarioId) {

        List<Prontuario> prontuarios = prontuarioRepository.findByVeterinarioId(veterinarioId);

        return prontuarios.stream().map((Prontuario p) -> {
            return converterParaDTO(p);
        }).toList();
    }

    private ProntuarioDTO converterParaDTO(Prontuario prontuario) {

        return ProntuarioDTO.builder()
                .id(prontuario.getId())
                .dataAtendimento(prontuario.getDataAtendimento())
                .observacoes(prontuario.getObservacoes())
                .animal(
                        AnimalDTO.builder()
                                .id(prontuario.getAnimal().getId())
                                .nome(prontuario.getAnimal().getNome())
                                .especie(prontuario.getAnimal().getEspecie())
                                .raca(prontuario.getAnimal().getRaca())
                                .dataNascimento(prontuario.getAnimal().getDataNascimento())
                                .tutor(
                                        TutorDTO.builder()
                                                .id(prontuario.getAnimal().getTutor().getId())
                                                .nome(prontuario.getAnimal().getTutor().getNome())
                                                .cpf(prontuario.getAnimal().getTutor().getCpf())
                                                .telefone(prontuario.getAnimal().getTutor().getTelefone())
                                                .endereco(prontuario.getAnimal().getTutor().getEndereco())
                                                .build()
                                )
                                .build()
                )
                .veterinario(
                        VeterinarioDTO.builder()
                                .id(prontuario.getVeterinario().getId())
                                .nome(prontuario.getVeterinario().getNome())
                                .crmv(prontuario.getVeterinario().getCrmv())
                                .especializacao(prontuario.getVeterinario().getEspecializacao())
                                .build()
                )
                .build();
    }
}