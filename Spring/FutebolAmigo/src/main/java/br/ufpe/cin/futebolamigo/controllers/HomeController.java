package br.ufpe.cin.futebolamigo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/home")
public class HomeController {
    @GetMapping
    public ResponseEntity<String> getHomePage(){
        return ResponseEntity.ok().body(
                "welcome to Api End point"
        );
    }
}
