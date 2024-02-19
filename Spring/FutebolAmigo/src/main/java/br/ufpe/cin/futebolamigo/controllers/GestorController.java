package br.ufpe.cin.futebolamigo.controllers;

import br.ufpe.cin.futebolamigo.dto.GestorDTO;
import br.ufpe.cin.futebolamigo.services.GestorService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/gestor")
@RequiredArgsConstructor
public class GestorController {
    private final GestorService gestorService;

    @GetMapping("/create")
    public String gestorCreate(Model model) {
        model.addAttribute("gestor", new GestorDTO());
        return "signupGestor";
    }

    @PostMapping("/create")
    public String gestorSave(@ModelAttribute("gestor") GestorDTO gestorDTO) {
        gestorService.createGestor(gestorDTO);
        return "gestorManagement";
    }

}
