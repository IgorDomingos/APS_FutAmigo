package br.ufpe.cin.futebolamigotime.controllers;

import br.ufpe.cin.futebolamigotime.models.Local;
import br.ufpe.cin.futebolamigotime.services.LocalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/local")
public class LocalController {

    public LocalController(LocalService localService) {
        this.localService = localService;
    }
    private final LocalService localService;

    @PostMapping
    public ResponseEntity create(@RequestBody Local localizacao, UriComponentsBuilder bodybuilder){
        var aux = localService.createLocal(localizacao);
        var uri = bodybuilder.path("/local/{id}").buildAndExpand(aux.getNome()).toUri();
        return ResponseEntity.created(uri).body(aux);
    }

    @GetMapping
    public ResponseEntity<Page<Local>> getAll(@PageableDefault Pageable page) {
        Page<Local> locais = localService.getAllLocal(page);
        return ResponseEntity.ok(locais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Local> getById(@PathVariable String id) {
        Optional<Local> jogador = localService.getLocalById(id);
        return jogador.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        localService.deleteLocal(id);
        return ResponseEntity.noContent().build();
    }

}
