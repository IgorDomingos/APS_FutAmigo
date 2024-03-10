package br.ufpe.cin.futebolamigotime.controllers;

import br.ufpe.cin.futebolamigotime.models.Treino;
import br.ufpe.cin.futebolamigotime.services.TreinoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Optional;

@RestController
@RequestMapping("/treino")
public class TreinoController {

    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }
    private final TreinoService treinoService;

    @PostMapping
    public ResponseEntity create(@RequestBody Treino treino, UriComponentsBuilder bodybuilder){
        var aux = treinoService.createTreino(treino);
        var uri = bodybuilder.path("/treino/{id}").buildAndExpand(aux.getId()).toUri();
        return ResponseEntity.created(uri).body(aux);
    }
    
    @GetMapping
    public ResponseEntity<Page<Treino>> getAll(@PageableDefault Pageable page) {
        Page<Treino> treinos = treinoService.getAllTreinos(page);
        return ResponseEntity.ok(treinos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Treino> getById(@PathVariable long id) {
        Optional<Treino> treino = treinoService.getTreinoById(id);
        return treino.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        treinoService.deleteTreino(id);
        return ResponseEntity.noContent().build();
    }
}