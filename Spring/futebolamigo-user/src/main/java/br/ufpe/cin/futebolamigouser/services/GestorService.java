package br.ufpe.cin.futebolamigo.services;

import br.ufpe.cin.futebolamigo.dto.GestorDTO;
import br.ufpe.cin.futebolamigo.dto.JogadorDTO;
import br.ufpe.cin.futebolamigo.models.Gestor;
import br.ufpe.cin.futebolamigo.repositories.GestorRepository;
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
