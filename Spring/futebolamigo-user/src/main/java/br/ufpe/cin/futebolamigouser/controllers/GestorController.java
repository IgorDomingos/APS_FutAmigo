package br.ufpe.cin.futebolamigouser.controllers;

import br.ufpe.cin.futebolamigouser.dto.GestorDTO;
import br.ufpe.cin.futebolamigouser.dto.JogadorDTO;
import br.ufpe.cin.futebolamigouser.dto.TimeDTO;
import br.ufpe.cin.futebolamigouser.dto.UserDTO;
import br.ufpe.cin.futebolamigouser.services.GestorService;
import br.ufpe.cin.futebolamigouser.services.JogadorService;
//import br.ufpe.cin.futebolamigouser.services.TimeService;
import br.ufpe.cin.futebolamigouser.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/gestor")
@RequiredArgsConstructor
public class GestorController {
    private final UserService userService;
    private final GestorService gestorService;
//    private final TimeService timeService;
    private final JogadorService jogadorService;


    @ModelAttribute("users")
    public List<UserDTO> getAllUsers() {
        return userService.findAllUsers();
    }
//    @ModelAttribute("times")
//    public List<TimeDTO> getAllTimes() {
//        return timeService.findAllTimes();
//    }
    @ModelAttribute("jogadores")
    public List<JogadorDTO> getAllJogadores() {
        return jogadorService.findAllJogadores();
    }
    @ModelAttribute("gestores")
    public List<GestorDTO> getAllGestores() {
        return gestorService.findAllGestores();
    }

    @GetMapping("/gestorManagement")
    public String gestorManagement() {
        return "gestorManagement";
    }
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
        return "createTime";
    }

    @PostMapping("/createTime")
    public String saveTime(@ModelAttribute("time") TimeDTO timeDTO) {
        timeService.createTime(timeDTO);
        return "gestorManagement";

    }



}
