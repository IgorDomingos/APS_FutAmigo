package br.ufpe.cin.futebolamigo.controllers;

import br.ufpe.cin.futebolamigo.models.Jogador;
import br.ufpe.cin.futebolamigo.models.Time;
import br.ufpe.cin.futebolamigo.services.TimeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/time")
public class TimeController {

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }
    private final TimeService timeService;

    @PostMapping
    public ResponseEntity create(@RequestBody Time time, UriComponentsBuilder bodybuilder){
        var aux = timeService.createTime(time);
        var uri = bodybuilder.path("/time/{nome}").buildAndExpand(aux.getNome()).toUri();
        return ResponseEntity.created(uri).body(aux);
    }

    @GetMapping
    public ResponseEntity<Page<Time>> getAll(@PageableDefault Pageable page) {
        Page<Time> times = timeService.getAllTimes(page);
        return ResponseEntity.ok(times);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> getById(@PathVariable long id) {
        Optional<Time> time = timeService.getTimeById(id);
        return time.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        timeService.deleteTime(id);
        return ResponseEntity.noContent().build();
    }
}
