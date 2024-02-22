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
    Jogador findByCpf(String cpf);
    JogadorDTO updateJogador(JogadorDTO jogadorDTO);
    List<JogadorDTO> findAllJogadores();
    void deleteJogador(String cpf);
}