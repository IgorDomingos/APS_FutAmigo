package br.ufpe.cin.futebolamigouser.services.impl;

import br.ufpe.cin.futebolamigouser.decorator.JogadorWithSkills;
import br.ufpe.cin.futebolamigouser.repositories.JogadorRepository;
import br.ufpe.cin.futebolamigouser.dto.JogadorDTO;
import br.ufpe.cin.futebolamigouser.models.Jogador;
import br.ufpe.cin.futebolamigouser.mapper.JogadorMapper;
import br.ufpe.cin.futebolamigouser.services.JogadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import user.JogadorClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JogadorServiceImpl implements JogadorService {
    private final JogadorRepository repository;
    private final JogadorMapper mapper;

//    private JogadorClient jogadorClient;
//    public void JogadorService(JogadorClient jogadorClient) {
//        this.jogadorClient = jogadorClient;
//    }
//
//    public SecurityProperties.User getJogadorById(Long id) {
//        ResponseEntity<SecurityProperties.User> response = jogadorClient.getJogadorById(id);
//        return response.getBody();
//    }

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

//    @Override
//    public List<JogadorDTO> findJogadoresByTimeId(Long timeId) {
//        return repository.findByTimeId(timeId);
//    }

    @Override
    public void updateSkills(String cpf, String skills) {
        Jogador jogador = repository.findByCpf(cpf);
        if (jogador != null) {
            JogadorWithSkills jogadorWithSkills = new JogadorWithSkills(jogador, skills);
            jogador.setSkills(jogadorWithSkills.getSkills());
            repository.save(jogador);
        }
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