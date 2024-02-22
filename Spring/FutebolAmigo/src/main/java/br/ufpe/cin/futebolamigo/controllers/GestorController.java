package br.ufpe.cin.futebolamigo.controllers;

import br.ufpe.cin.futebolamigo.dto.GestorDTO;
import br.ufpe.cin.futebolamigo.dto.TimeDTO;
import br.ufpe.cin.futebolamigo.services.GestorService;
import br.ufpe.cin.futebolamigo.services.JogadorService;
import br.ufpe.cin.futebolamigo.services.TimeService;
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
    private final TimeService timeService;
    private final JogadorService jogadorService;

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

    @PostMapping("/update")
    public String updateGestor(@ModelAttribute GestorDTO gestorDTO) {
        gestorService.updateGestor(gestorDTO);
        return "gestorManagement";
    }

    @PostMapping("/delete")
    public String deleteGestor(@ModelAttribute GestorDTO gestorDTO) {
        gestorService.deleteGestor(gestorDTO.getCpfGestor());
        return "gestorManagement";
    }

    @GetMapping("/createTime")
    public String createTime(Model model) {
        model.addAttribute("time", new TimeDTO());
        model.addAttribute("todosOsJogadores", jogadorService.findAllJogadores());
        return "createTime";
    }

    @PostMapping("/createTime")
    public String saveTime(@ModelAttribute("time") TimeDTO timeDTO) {
        timeService.createTime(timeDTO);
        return "gestorManagement";

    }



}
