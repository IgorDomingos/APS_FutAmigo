package br.ufpe.cin.futebolamigo.controllers;

import br.ufpe.cin.futebolamigo.models.Jogador;
import br.ufpe.cin.futebolamigo.services.JogadorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Optional;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }
    private final JogadorService jogadorService;

    @PostMapping
    public ResponseEntity create(@RequestBody Jogador jogador, UriComponentsBuilder bodybuilder){
        var aux = jogadorService.createJogador(jogador);
        var uri = bodybuilder.path("/jogador/{id}").buildAndExpand(aux.getCpf()).toUri();
        return ResponseEntity.created(uri).body(aux);
    }

    @GetMapping
    public ResponseEntity<Page<Jogador>> getAll(@PageableDefault Pageable page) {
        Page<Jogador> jogadores = jogadorService.getAllJogadores(page);
        return ResponseEntity.ok(jogadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> getById(@PathVariable String id) {
        Optional<Jogador> jogador = jogadorService.getJogadorById(id);
        return jogador.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        jogadorService.deleteJogador(id);
        return ResponseEntity.noContent().build();
    }
}