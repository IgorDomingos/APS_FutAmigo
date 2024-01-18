package br.ufpe.cin.futebolamigo.services;

import br.ufpe.cin.futebolamigo.repositories.JogadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JogadorService {
    private JogadorRepository jogadorRepository;
}
