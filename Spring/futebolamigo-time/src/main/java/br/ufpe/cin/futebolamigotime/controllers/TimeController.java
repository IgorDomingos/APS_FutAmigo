package br.ufpe.cin.futebolamigotime.controllers;

//import br.ufpe.cin.futebolamigotime.dto.GestorDTO;
//import br.ufpe.cin.futebolamigotime.dto.JogadorDTO;
import br.ufpe.cin.futebolamigotime.dto.TimeDTO;
//import br.ufpe.cin.futebolamigotime.dto.UserDTO;
//import br.ufpe.cin.futebolamigotime.mapper.JogadorMapper;
import br.ufpe.cin.futebolamigotime.mapper.TimeMapper;
//import br.ufpe.cin.futebolamigotime.models.Jogador;
import br.ufpe.cin.futebolamigotime.models.Time;
//import br.ufpe.cin.futebolamigotime.services.GestorService;
//import br.ufpe.cin.futebolamigotime.services.JogadorService;
import br.ufpe.cin.futebolamigotime.services.TimeService;
//import br.ufpe.cin.futebolamigotime.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/time")
@RequiredArgsConstructor
public class TimeController {
    private final TimeService timeService;


    @Autowired

    private final TimeMapper timeMapper;

    @ModelAttribute("times")
    public List<TimeDTO> getAllTimes() {
        return timeService.findAllTimes();
    }

    @GetMapping("/timeManagement")
    public String timeManagement() {
        return "timeManagement";
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

//    @PostMapping("/addPlayer")
//    public String addPlayerToTime(@RequestParam("time") String nomeTime, @RequestParam("jogadores") List<String> cpfJogadores) {
//        // Buscar o time pelo nome
//        Time time = timeService.findByNome(nomeTime);
//
//        // Para cada cpf de jogador recebido, buscar o jogador correspondente e adicioná-lo à lista de jogadores do time
//        for (String cpf : cpfJogadores) {
//            Jogador jogador = jogadorService.findByCpf(cpf);
//            time.getJogadores().add(jogador);
//        }
//
//        // Converter o Time para TimeDTO
//        TimeDTO timeDTO = timeMapper.convertToDto(time);
//
//        // Salvar o time atualizado no banco de dados
//        timeService.updateTime(timeDTO);
//
//        // Redirecionar para a página de gerenciamento de times
//        return "redirect:/time/timeManagement";
//    }

}