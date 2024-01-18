package br.ufpe.cin.futebolamigo.services;

import br.ufpe.cin.futebolamigo.models.Gestor;
import br.ufpe.cin.futebolamigo.repositories.GestorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class GestorService {
    private final GestorRepository gestorRepository;

    public GestorService(GestorRepository gestorRepository) {
        this.gestorRepository = gestorRepository;
    }

    public Gestor createGestor(Gestor gestor) {
        return gestorRepository.save(gestor);
    }

    public Page<Gestor> getAllGestores(Pageable page) {
        return gestorRepository.findAll(page);
    }

    public Optional<Gestor> getGestorById(String gestorId) {
        return gestorRepository.findById(gestorId);
    }

//    public Gestor updateGestor(String gestorId, Gestor gestor) {
//        if (gestorRepository.existsById(gestorId)) {
//            gestor.setId(gestorId);
//            return gestorRepository.save(gestor);
//        } else {
//            // Pode lançar uma exceção ou tratar de outra forma
//            return null;
//        }
//    }

    public void deleteGestor(String gestorId) {
        gestorRepository.deleteById(gestorId);
    }
}
