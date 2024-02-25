package br.ufpe.cin.futebolamigo.controllers;

import br.ufpe.cin.futebolamigo.dto.GestorDTO;
import br.ufpe.cin.futebolamigo.dto.JogadorDTO;
import br.ufpe.cin.futebolamigo.dto.TimeDTO;
import br.ufpe.cin.futebolamigo.dto.UserDTO;
import br.ufpe.cin.futebolamigo.mapper.JogadorMapper;
import br.ufpe.cin.futebolamigo.mapper.TimeMapper;
import br.ufpe.cin.futebolamigo.models.Jogador;
import br.ufpe.cin.futebolamigo.models.Time;
import br.ufpe.cin.futebolamigo.services.GestorService;
import br.ufpe.cin.futebolamigo.services.JogadorService;
import br.ufpe.cin.futebolamigo.services.TimeService;
import br.ufpe.cin.futebolamigo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final UserService userService;

    @Autowired
    private final JogadorMapper jogadorMapper;
    private final TimeMapper timeMapper;

    @ModelAttribute("users")
    public List<UserDTO> getAllUsers() {
        return userService.findAllUsers();
    }
    @ModelAttribute("times")
    public List<TimeDTO> getAllTimes() {
        return timeService.findAllTimes();
    }
    @ModelAttribute("gestores")
    public List<GestorDTO> getAllGestores() {
        return gestorService.findAllGestores();
    }
    @ModelAttribute("jogadores")
    public List<JogadorDTO> getAllJogadores() {
        return jogadorService.findAllJogadores();
    }
    @GetMapping("/timeManagement")
    public String timeManagement() {
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

    @PostMapping("/addPlayer")
    public String addPlayerToTime(@RequestParam("time") String nomeTime, @RequestParam("jogadores") List<String> cpfJogadores) {
        // Buscar o time pelo nome
        Time time = timeService.findByNome(nomeTime);

        // Para cada cpf de jogador recebido, buscar o jogador correspondente e adicioná-lo à lista de jogadores do time
        for (String cpf : cpfJogadores) {
            Jogador jogador = jogadorService.findByCpf(cpf);
            time.getJogadores().add(jogador);
        }

        // Converter o Time para TimeDTO
        TimeDTO timeDTO = timeMapper.convertToDto(time);

        // Salvar o time atualizado no banco de dados
        timeService.updateTime(timeDTO);

        // Redirecionar para a página de gerenciamento de times
        return "redirect:/time/timeManagement";
    }

}