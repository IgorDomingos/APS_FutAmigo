package br.ufpe.cin.futebolamigouser.services.impl;

import br.ufpe.cin.futebolamigouser.repositories.GestorRepository;
import br.ufpe.cin.futebolamigouser.dto.GestorDTO;
import br.ufpe.cin.futebolamigouser.models.Gestor;
import br.ufpe.cin.futebolamigouser.mapper.GestorMapper;
import br.ufpe.cin.futebolamigouser.services.GestorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import user.GestorClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GestorServiceImpl implements GestorService {
    private final GestorRepository repository;
    private final GestorMapper mapper;

    private GestorClient gestorClient;
    public void GestorService(GestorClient gestorClient) {
        this.gestorClient = gestorClient;
    }

    public SecurityProperties.User getGestorById(Long id) {
        ResponseEntity<SecurityProperties.User> response = gestorClient.getGestorById(id);
        return response.getBody();
    }

    @Override
    public GestorDTO createGestor(GestorDTO gestorDTO) {
        Gestor gestorToSave = mapper.convertToEntity(gestorDTO);
        Gestor savedGestor = repository.save(gestorToSave);
        return mapper.convertToDto(savedGestor);
    }


    @Override
    public List<GestorDTO> findAllGestores() {
        List<Gestor> gestores = repository.findAll();
        return gestores.stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Gestor findByCpfGestor(String cpf) {
        return repository.findByCpfGestor(cpf);
    }

    @Override
    public GestorDTO updateGestor(GestorDTO gestorDTO) {
        Gestor gestorToUpdate = mapper.convertToEntity(gestorDTO);
        Gestor updatedGestor = repository.save(gestorToUpdate);
        return mapper.convertToDto(updatedGestor);
    }

    @Override
    public void deleteGestor(String cpf) {
        repository.deleteByCpfGestor(cpf);
    }
}