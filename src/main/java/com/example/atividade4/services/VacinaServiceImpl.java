package com.example.atividade4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade4.dtos.AnimalDTO;
import com.example.atividade4.dtos.InserirVacinaDTO;
import com.example.atividade4.dtos.TutorDTO;
import com.example.atividade4.dtos.VacinaDTO;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Animal;
import com.example.atividade4.models.Vacina;
import com.example.atividade4.repositories.AnimalRepository;
import com.example.atividade4.repositories.VacinaRepository;

@Service
public class VacinaServiceImpl implements VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public Vacina salvar(InserirVacinaDTO vacinaDTO) {

        Animal animal = animalRepository.findById(vacinaDTO.getAnimalId())
                .orElseThrow(() -> new RegraNegocioException("Animal não encontrado"));

        Vacina vacina = Vacina.builder()
                .nome(vacinaDTO.getNome())
                .dataAplicacao(vacinaDTO.getDataAplicacao())
                .dataProximaDose(vacinaDTO.getDataProximaDose())
                .observacoes(vacinaDTO.getObservacoes())
                .animal(animal)
                .build();

        return vacinaRepository.save(vacina);
    }

    @Override
    public List<VacinaDTO> buscarTodos() {

        List<Vacina> vacinas = vacinaRepository.findAll();

        return vacinas.stream().map((Vacina v) -> {
            return converterParaDTO(v);
        }).toList();
    }

    @Override
    public VacinaDTO buscarPorId(Long id) {

        Vacina vacina = vacinaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Vacina não encontrada"));

        return converterParaDTO(vacina);
    }

    @Override
    public List<VacinaDTO> buscarPorAnimal(Long animalId) {

        List<Vacina> vacinas = vacinaRepository.findByAnimalId(animalId);

        return vacinas.stream().map((Vacina v) -> {
            return converterParaDTO(v);
        }).toList();
    }

    @Override
    public List<VacinaDTO> buscarPorNome(String nome) {

        List<Vacina> vacinas = vacinaRepository.findByNomeLike(nome);

        return vacinas.stream().map((Vacina v) -> {
            return converterParaDTO(v);
        }).toList();
    }

    private VacinaDTO converterParaDTO(Vacina vacina) {

        return VacinaDTO.builder()
                .id(vacina.getId())
                .nome(vacina.getNome())
                .dataAplicacao(vacina.getDataAplicacao())
                .dataProximaDose(vacina.getDataProximaDose())
                .observacoes(vacina.getObservacoes())
                .animal(
                        AnimalDTO.builder()
                                .id(vacina.getAnimal().getId())
                                .nome(vacina.getAnimal().getNome())
                                .especie(vacina.getAnimal().getEspecie())
                                .raca(vacina.getAnimal().getRaca())
                                .dataNascimento(vacina.getAnimal().getDataNascimento())
                                .tutor(
                                        TutorDTO.builder()
                                                .id(vacina.getAnimal().getTutor().getId())
                                                .nome(vacina.getAnimal().getTutor().getNome())
                                                .cpf(vacina.getAnimal().getTutor().getCpf())
                                                .telefone(vacina.getAnimal().getTutor().getTelefone())
                                                .endereco(vacina.getAnimal().getTutor().getEndereco())
                                                .build()
                                )
                                .build()
                )
                .build();
    }
}