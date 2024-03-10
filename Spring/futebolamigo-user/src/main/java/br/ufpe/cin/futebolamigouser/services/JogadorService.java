package br.ufpe.cin.futebolamigouser.services;

import br.ufpe.cin.futebolamigouser.dto.JogadorDTO;
import br.ufpe.cin.futebolamigouser.dto.UserDTO;
import br.ufpe.cin.futebolamigouser.models.Jogador;
import br.ufpe.cin.futebolamigouser.repositories.JogadorRepository;
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

    void updateSkills(String cpf, String skills);

//    List<JogadorDTO> findJogadoresByTimeId(Long timeId);
}