package br.ufpe.cin.futebolamigouser.controllers;

import br.ufpe.cin.futebolamigouser.dto.JogadorDTO;
import br.ufpe.cin.futebolamigouser.dto.UserDTO;
import br.ufpe.cin.futebolamigouser.services.JogadorService;
import br.ufpe.cin.futebolamigouser.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@RequestMapping("/jogador")
@RequiredArgsConstructor
public class JogadorController {
    private final JogadorService jogadorService;
    private final UserService userService;

    @ModelAttribute("users")
    public List<UserDTO> getAllUsers() {
        return userService.findAllUsers();
    }
    @ModelAttribute("jogadores")
    public List<JogadorDTO> getAllJogadores() {
        return jogadorService.findAllJogadores();
    }

    @GetMapping("/create")
    public String jogadorCreate(Model model) {
        model.addAttribute("jogador", new JogadorDTO());
        return "signupJogador";
    }

    @GetMapping("/jogadorManagement")
    public String jogadorManagement() {
        return "jogadorManagement";
    }
    @PostMapping("/create")
    public String jogadorSave(@ModelAttribute("jogador") JogadorDTO jogadorDTO) {
        jogadorService.createJogador(jogadorDTO);
        return "jogadorManagement";
    }

    @PostMapping("/update")
    public String updateJogador(@ModelAttribute JogadorDTO jogadorDTO) {
        jogadorService.updateJogador(jogadorDTO);
        return "jogadorManagement";
    }

    @PostMapping("/delete")
    public String deleteJogador(@ModelAttribute JogadorDTO jogadorDTO) {
        jogadorService.deleteJogador(jogadorDTO.getCpf());
        return "jogadorManagement";
    }

    @PostMapping("/updateSkills")
    public String updateSkills(@RequestParam("cpf") String cpf, @RequestParam("skills") String skills) {
        jogadorService.updateSkills(cpf, skills);
        return "jogadorManagement";
    }

}