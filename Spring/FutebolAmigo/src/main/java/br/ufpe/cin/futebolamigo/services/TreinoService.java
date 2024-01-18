package br.ufpe.cin.futebolamigo.services;

import br.ufpe.cin.futebolamigo.repositories.TreinoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TreinoService {
    private TreinoRepository treinoRepository;
}
