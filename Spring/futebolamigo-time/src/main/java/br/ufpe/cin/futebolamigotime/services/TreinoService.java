package br.ufpe.cin.futebolamigo.services;

import br.ufpe.cin.futebolamigo.models.Treino;
import br.ufpe.cin.futebolamigo.repositories.TreinoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TreinoService {

    public TreinoService(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }
    private TreinoRepository treinoRepository;

    public Treino createTreino(Treino treino) {
        return treinoRepository.save(treino);
    }

    public Page<Treino> getAllTreinos(Pageable page) {
        return treinoRepository.findAll(page);
    }

    public Optional<Treino> getTreinoById(long treinoId) {
        return treinoRepository.findById(treinoId);
    }

    public void deleteTreino(long treinoId) {
        treinoRepository.deleteById(treinoId);
    }
}
