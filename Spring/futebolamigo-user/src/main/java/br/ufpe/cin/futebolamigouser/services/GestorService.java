package br.ufpe.cin.futebolamigouser.services;

import br.ufpe.cin.futebolamigouser.dto.GestorDTO;
import br.ufpe.cin.futebolamigouser.dto.JogadorDTO;
import br.ufpe.cin.futebolamigouser.models.Gestor;
import br.ufpe.cin.futebolamigouser.repositories.GestorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GestorService {

    GestorDTO createGestor(GestorDTO gestorDTO);

    List<GestorDTO> findAllGestores();

    Gestor findByCpfGestor(String cpf);

    void deleteGestor(String cpf);

    GestorDTO updateGestor(GestorDTO gestorDTO);
}
