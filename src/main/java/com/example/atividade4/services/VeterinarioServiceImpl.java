package com.example.atividade4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade4.dtos.InserirVeterinarioDTO;
import com.example.atividade4.dtos.VeterinarioDTO;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Veterinario;
import com.example.atividade4.repositories.VeterinarioRepository;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Override
    public Veterinario salvar(InserirVeterinarioDTO veterinarioDTO) {

        Veterinario veterinario = Veterinario.builder()
                .nome(veterinarioDTO.getNome())
                .crmv(veterinarioDTO.getCrmv())
                .especializacao(veterinarioDTO.getEspecializacao())
                .build();

        return veterinarioRepository.save(veterinario);
    }

    @Override
    public List<VeterinarioDTO> buscarTodos() {

        List<Veterinario> veterinarios = veterinarioRepository.findAll();

        return veterinarios.stream().map((Veterinario v) -> {
            return converterParaDTO(v);
        }).toList();
    }

    @Override
    public VeterinarioDTO buscarPorId(Long id) {

        Veterinario veterinario = veterinarioRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Veterinário não encontrado"));

        return converterParaDTO(veterinario);
    }

    @Override
    public VeterinarioDTO buscarPorCrmv(String crmv) {

        Veterinario veterinario = veterinarioRepository.findByCrmv(crmv)
                .orElseThrow(() -> new RegraNegocioException("Veterinário não encontrado"));

        return converterParaDTO(veterinario);
    }

    @Override
    public List<VeterinarioDTO> buscarPorNome(String nome) {

        List<Veterinario> veterinarios = veterinarioRepository.findByNomeLike(nome);

        return veterinarios.stream().map((Veterinario v) -> {
            return converterParaDTO(v);
        }).toList();
    }

    @Override
    public List<VeterinarioDTO> buscarPorEspecializacao(String especializacao) {

        List<Veterinario> veterinarios = veterinarioRepository.findByEspecializacao(especializacao);

        return veterinarios.stream().map((Veterinario v) -> {
            return converterParaDTO(v);
        }).toList();
    }

    private VeterinarioDTO converterParaDTO(Veterinario veterinario) {

        return VeterinarioDTO.builder()
                .id(veterinario.getId())
                .nome(veterinario.getNome())
                .crmv(veterinario.getCrmv())
                .especializacao(veterinario.getEspecializacao())
                .build();
    }
}