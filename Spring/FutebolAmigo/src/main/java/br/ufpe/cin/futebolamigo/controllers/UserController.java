package br.ufpe.cin.futebolamigo.controllers;

import br.ufpe.cin.futebolamigo.dto.GestorDTO;
import br.ufpe.cin.futebolamigo.dto.JogadorDTO;
import br.ufpe.cin.futebolamigo.dto.TimeDTO;
import br.ufpe.cin.futebolamigo.dto.UserDTO;
import br.ufpe.cin.futebolamigo.events.UserUpdateEvent;
import br.ufpe.cin.futebolamigo.services.GestorService;
import br.ufpe.cin.futebolamigo.services.JogadorService;
import br.ufpe.cin.futebolamigo.services.TimeService;
import br.ufpe.cin.futebolamigo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final GestorService gestorService;
    private final JogadorService jogadorService;
    private final TimeService timeService;
    private final ApplicationEventPublisher eventPublisher;
    @GetMapping("/create")
    public String userCreate(Model model){
        model.addAttribute("user",new UserDTO());

        return "signup";
    }
    @PostMapping("/create")
    public String userSave(@ModelAttribute("user") UserDTO userDTO){
        userService.createUser(userDTO);
        UserDTO clonedUserDTO = (UserDTO) userDTO.clone();
        clonedUserDTO.setUserName("Clone" + clonedUserDTO.getUserName());
        clonedUserDTO.setFirstName("Clone" + clonedUserDTO.getFirstName());
        userService.createUser(clonedUserDTO);
        return "redirect:/login";
    }

    @GetMapping("/userManagement")
    public String userManagement() {
        return "userManagement";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute UserDTO userDTO) {
        userService.updateUser(userDTO.getId().toString(), userDTO);
        eventPublisher.publishEvent(new UserUpdateEvent(this, userDTO));
        return "redirect:/user/userManagement";
    }

    @PostMapping("/delete")
    public String deleteUser(@ModelAttribute UserDTO userDTO) {
        userService.deleteUser(userDTO.getId().toString());
        return "redirect:/user/userManagement";
    }

    @PostMapping("/find")
    public String findByUserName(@ModelAttribute UserDTO userDTO) {
        userService.findByUserName(userDTO.getUserName());
        return "redirect:/user/userManagement";
    }

    @GetMapping("/show")
    public String show(Model model) {
        List<UserDTO> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "show";
    }

    @PostMapping("/findGestor")
    public String findGestor(@ModelAttribute GestorDTO gestorDTO) {
        gestorService.findByCpfGestor(gestorDTO.getCpfGestor());
        return "redirect:/user/userManagement";
    }

    @PostMapping("/findJogador")
    public String findJogador(@ModelAttribute JogadorDTO jogadorDTO) {
        jogadorService.findByCpf(jogadorDTO.getCpf());
        return "redirect:/user/userManagement";
    }

    @PostMapping("/findTime")
    public String findTime(@ModelAttribute TimeDTO timeDTO) {
        timeService.findByNome(timeDTO.getNome());
        return "redirect:/user/userManagement";
    }


}
