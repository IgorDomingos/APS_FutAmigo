package br.ufpe.cin.futebolamigo.services.impl;

import br.ufpe.cin.futebolamigo.repositories.JogadorRepository;
import br.ufpe.cin.futebolamigo.dto.JogadorDTO;
import br.ufpe.cin.futebolamigo.models.Jogador;
import br.ufpe.cin.futebolamigo.mapper.JogadorMapper;
import br.ufpe.cin.futebolamigo.services.JogadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JogadorServiceImpl implements JogadorService {
    private final JogadorRepository repository;
    private final JogadorMapper mapper;

    @Override
    public JogadorDTO createJogador(JogadorDTO jogadorDTO) {
        Jogador jogadorToSave = mapper.convertToEntity(jogadorDTO);
        Jogador savedJogador = repository.save(jogadorToSave);
        return mapper.convertToDto(savedJogador);
    }

    @Override
    public List<JogadorDTO> findAllJogadores() {
        List<Jogador> jogadores = repository.findAll();
        return jogadores.stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public JogadorDTO updateJogador(JogadorDTO jogadorDTO) {
        Jogador jogadorToUpdate = mapper.convertToEntity(jogadorDTO);
        Jogador updatedJogador = repository.save(jogadorToUpdate);
        return mapper.convertToDto(updatedJogador);
    }

    @Override
    public void deleteJogador(String cpf) {
        repository.deleteByCpf(cpf);
    }

    @Override
    public Jogador findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}