package br.ufpe.cin.futebolamigotime.services;

import br.ufpe.cin.futebolamigotime.models.Local;
import br.ufpe.cin.futebolamigotime.repositories.LocalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocalService {
    private LocalRepository localRepository;

    public LocalService(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    public Local createLocal(Local localizacao) {
        return localRepository.save(localizacao);
    }

    public Page<Local> getAllLocal(Pageable page) {
        return localRepository.findAll(page);
    }

    public Optional<Local> getLocalById(String localId) {
        return localRepository.findById(localId);
    }

    public void deleteLocal(String localId) {
        localRepository.deleteById(localId);
    }
}
