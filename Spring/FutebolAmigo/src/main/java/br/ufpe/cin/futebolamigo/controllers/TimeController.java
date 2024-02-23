package br.ufpe.cin.futebolamigo.controllers;

import br.ufpe.cin.futebolamigo.dto.GestorDTO;
import br.ufpe.cin.futebolamigo.dto.JogadorDTO;
import br.ufpe.cin.futebolamigo.dto.TimeDTO;
import br.ufpe.cin.futebolamigo.services.GestorService;
import br.ufpe.cin.futebolamigo.services.JogadorService;
import br.ufpe.cin.futebolamigo.services.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/time")
@RequiredArgsConstructor
public class TimeController {
    private final TimeService timeService;
    private final GestorService gestorService;
    private final JogadorService jogadorService;

    @ModelAttribute("gestores")
    public List<GestorDTO> getAllGestores() {
        return gestorService.findAllGestores();
    }
    @ModelAttribute("jogadores")
    public List<JogadorDTO> getAllJogadores() {
        return jogadorService.findAllJogadores();
    }
    @GetMapping("/create")
    public String timeCreate(Model model) {
        model.addAttribute("time", new TimeDTO());
        return "createTime";
    }

    @PostMapping("/create")
    public String timeSave(@ModelAttribute("time") TimeDTO timeDTO) {
        timeService.createTime(timeDTO);
        return "timeManagement";
    }

    @PostMapping("/update")
    public String updateTime(@ModelAttribute TimeDTO timeDTO) {
        timeService.updateTime(timeDTO);
        return "timeManagement";
    }

    @PostMapping("/delete")
    public String deleteTime(@ModelAttribute TimeDTO timeDTO) {
        timeService.deleteTime(timeDTO.getNome());
        return "timeManagement";
    }

    @PostMapping("/find")
    public String findTime(@ModelAttribute TimeDTO timeDTO) {
        timeService.findByNome(timeDTO.getNome());
        return "timeManagement";
    }
}