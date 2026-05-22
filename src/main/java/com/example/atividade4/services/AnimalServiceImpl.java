package com.example.atividade4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade4.dtos.AnimalDTO;
import com.example.atividade4.dtos.InserirAnimalDTO;
import com.example.atividade4.dtos.TutorDTO;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Animal;
import com.example.atividade4.models.Tutor;
import com.example.atividade4.repositories.AnimalRepository;
import com.example.atividade4.repositories.TutorRepository;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public Animal salvar(InserirAnimalDTO animalDTO) {

        Tutor tutor = tutorRepository.findById(animalDTO.getTutorId())
                .orElseThrow(() -> new RegraNegocioException("Tutor não encontrado"));

        Animal animal = Animal.builder()
                .nome(animalDTO.getNome())
                .especie(animalDTO.getEspecie())
                .raca(animalDTO.getRaca())
                .dataNascimento(animalDTO.getDataNascimento())
                .tutor(tutor)
                .build();

        return animalRepository.save(animal);
    }

    @Override
    public List<AnimalDTO> buscarTodos() {

        List<Animal> animais = animalRepository.findAll();

        return animais.stream().map((Animal a) -> {
            return converterParaDTO(a);
        }).toList();
    }

    @Override
    public AnimalDTO buscarPorId(Long id) {

        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Animal não encontrado"));

        return converterParaDTO(animal);
    }

    @Override
    public List<AnimalDTO> buscarPorTutor(Long tutorId) {

        List<Animal> animais = animalRepository.findByTutorId(tutorId);

        return animais.stream().map((Animal a) -> {
            return converterParaDTO(a);
        }).toList();
    }

    @Override
    public List<AnimalDTO> buscarPorEspecie(String especie) {

        List<Animal> animais = animalRepository.findByEspecie(especie);

        return animais.stream().map((Animal a) -> {
            return converterParaDTO(a);
        }).toList();
    }

    private AnimalDTO converterParaDTO(Animal animal) {

        return AnimalDTO.builder()
                .id(animal.getId())
                .nome(animal.getNome())
                .especie(animal.getEspecie())
                .raca(animal.getRaca())
                .dataNascimento(animal.getDataNascimento())
                .tutor(
                        TutorDTO.builder()
                                .id(animal.getTutor().getId())
                                .nome(animal.getTutor().getNome())
                                .cpf(animal.getTutor().getCpf())
                                .telefone(animal.getTutor().getTelefone())
                                .endereco(animal.getTutor().getEndereco())
                                .build()
                )
                .build();
    }
}