package br.ufpe.cin.futebolamigo.services;

import br.ufpe.cin.futebolamigo.dto.JogadorDTO;
import br.ufpe.cin.futebolamigo.dto.UserDTO;
import br.ufpe.cin.futebolamigo.models.Jogador;
import br.ufpe.cin.futebolamigo.repositories.JogadorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface JogadorService {
    JogadorDTO createJogador(JogadorDTO jogadorDTO);

    List<JogadorDTO> findAllJogadores();


//    public JogadorService(JogadorRepository jogadorRepository) {
//        this.jogadorRepository = jogadorRepository;
//    }
//    private JogadorRepository jogadorRepository;
//
//    public Jogador createJogador(Jogador jogador) {
//        return jogadorRepository.save(jogador);
//    }
//
//    public Page<Jogador> getAllJogadores(Pageable page) {
//        return jogadorRepository.findAll(page);
//    }
//
//    public Optional<Jogador> getJogadorById(String jogadorId) {
//        return jogadorRepository.findById(jogadorId);
//    }
//
//    public void deleteJogador(String jogadorId) {
//        jogadorRepository.deleteById(jogadorId);
//    }
}