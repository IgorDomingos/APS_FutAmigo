package br.ufpe.cin.futebolamigouser.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public ResponseEntity<String> getHomePage(){
        return ResponseEntity.ok().body(
                "welcome to Api End point"
        );
    }
}
