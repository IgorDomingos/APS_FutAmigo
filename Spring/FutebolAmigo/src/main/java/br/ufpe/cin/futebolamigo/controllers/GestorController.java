package br.ufpe.cin.futebolamigo.controllers;

import br.ufpe.cin.futebolamigo.models.Gestor;
import br.ufpe.cin.futebolamigo.services.GestorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/gestor")
//@RequiredArgsConstructor
public class GestorController {

//    public GestorController(GestorService gestorService) {
//        this.gestorService = gestorService;
//    }
//    private final GestorService gestorService;
//
//    @PostMapping
//    public ResponseEntity create(@RequestBody Gestor gestor, UriComponentsBuilder bodybuilder){
//        var aux = gestorService.createGestor(gestor);
//        var uri = bodybuilder.path("/gestor/{id}").buildAndExpand(aux.getCpf()).toUri();
//        return ResponseEntity.created(uri).body(aux);
//    }
//    @GetMapping
//    public ResponseEntity<Page<Gestor>> getAll(@PageableDefault Pageable page) {
//        Page<Gestor> gestores = gestorService.getAllGestores(page);
//        return ResponseEntity.ok(gestores);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Gestor> getById(@PathVariable String id) {
//        Optional<Gestor> gestor = gestorService.getGestorById(id);
//        return gestor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }
//
////    @PutMapping("/{id}")
////    public ResponseEntity<Gestor> update(@PathVariable Long id, @RequestBody Gestor gestor) {
////        Gestor updatedGestor = gestorService.updateGestor(id, gestor);
////        return updatedGestor != null ?
////                ResponseEntity.ok(updatedGestor) :
////                ResponseEntity.notFound().build();
////    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable String id) {
//        gestorService.deleteGestor(id);
//        return ResponseEntity.noContent().build();
//    }
}
