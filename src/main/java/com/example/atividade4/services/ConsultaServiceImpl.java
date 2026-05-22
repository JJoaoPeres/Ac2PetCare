package com.example.atividade4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade4.dtos.AnimalDTO;
import com.example.atividade4.dtos.ConsultaDTO;
import com.example.atividade4.dtos.InserirConsultaDTO;
import com.example.atividade4.dtos.TutorDTO;
import com.example.atividade4.dtos.VeterinarioDTO;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Animal;
import com.example.atividade4.models.Consulta;
import com.example.atividade4.models.Veterinario;
import com.example.atividade4.repositories.AnimalRepository;
import com.example.atividade4.repositories.ConsultaRepository;
import com.example.atividade4.repositories.VeterinarioRepository;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Override
    public Consulta salvar(InserirConsultaDTO consultaDTO) {

        Animal animal = animalRepository.findById(consultaDTO.getAnimalId())
                .orElseThrow(() -> new RegraNegocioException("Animal não encontrado"));

        Veterinario veterinario = veterinarioRepository.findById(consultaDTO.getVeterinarioId())
                .orElseThrow(() -> new RegraNegocioException("Veterinário não encontrado"));

        boolean veterinarioOcupado = consultaRepository.existsByVeterinarioIdAndDataAndHora(
                consultaDTO.getVeterinarioId(),
                consultaDTO.getData(),
                consultaDTO.getHora()
        );

        if (veterinarioOcupado) {
            throw new RegraNegocioException("Veterinário já possui consulta nesse dia e horário");
        }

        if (!veterinario.getEspecializacao().equalsIgnoreCase(animal.getEspecie())) {
            throw new RegraNegocioException("Veterinário não possui especialização para atender essa espécie");
        }

        Consulta consulta = Consulta.builder()
                .local(consultaDTO.getLocal())
                .data(consultaDTO.getData())
                .hora(consultaDTO.getHora())
                .animal(animal)
                .veterinario(veterinario)
                .build();

        return consultaRepository.save(consulta);
    }

    @Override
    public List<ConsultaDTO> buscarTodos() {

        List<Consulta> consultas = consultaRepository.findAll();

        return consultas.stream().map((Consulta c) -> {
            return converterParaDTO(c);
        }).toList();
    }

    @Override
    public ConsultaDTO buscarPorId(Long id) {

        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Consulta não encontrada"));

        return converterParaDTO(consulta);
    }

    @Override
    public List<ConsultaDTO> buscarPorAnimal(Long animalId) {

        List<Consulta> consultas = consultaRepository.findByAnimalId(animalId);

        return consultas.stream().map((Consulta c) -> {
            return converterParaDTO(c);
        }).toList();
    }

    @Override
    public List<ConsultaDTO> buscarPorVeterinario(Long veterinarioId) {

        List<Consulta> consultas = consultaRepository.findByVeterinarioId(veterinarioId);

        return consultas.stream().map((Consulta c) -> {
            return converterParaDTO(c);
        }).toList();
    }

    private ConsultaDTO converterParaDTO(Consulta consulta) {

        return ConsultaDTO.builder()
                .id(consulta.getId())
                .local(consulta.getLocal())
                .data(consulta.getData())
                .hora(consulta.getHora())
                .animal(
                        AnimalDTO.builder()
                                .id(consulta.getAnimal().getId())
                                .nome(consulta.getAnimal().getNome())
                                .especie(consulta.getAnimal().getEspecie())
                                .raca(consulta.getAnimal().getRaca())
                                .dataNascimento(consulta.getAnimal().getDataNascimento())
                                .tutor(
                                        TutorDTO.builder()
                                                .id(consulta.getAnimal().getTutor().getId())
                                                .nome(consulta.getAnimal().getTutor().getNome())
                                                .cpf(consulta.getAnimal().getTutor().getCpf())
                                                .telefone(consulta.getAnimal().getTutor().getTelefone())
                                                .endereco(consulta.getAnimal().getTutor().getEndereco())
                                                .build()
                                )
                                .build()
                )
                .veterinario(
                        VeterinarioDTO.builder()
                                .id(consulta.getVeterinario().getId())
                                .nome(consulta.getVeterinario().getNome())
                                .crmv(consulta.getVeterinario().getCrmv())
                                .especializacao(consulta.getVeterinario().getEspecializacao())
                                .build()
                )
                .build();
    }
}