package br.ufpe.cin.futebolamigo.controllers;

import br.ufpe.cin.futebolamigo.dto.UserDTO;
import br.ufpe.cin.futebolamigo.models.User;
import br.ufpe.cin.futebolamigo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/create")
    public String userCreate(Model model){
        model.addAttribute("user",new UserDTO());

        return "signup";
    }
    @PostMapping("/create")
    public String userSave(@ModelAttribute("user") UserDTO userDTO){
        userService.createUser(userDTO);
        return "redirect:/login";
    }

    @GetMapping("/userManagement")
    public String userManagement() {
        return "userManagement";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute UserDTO userDTO) {
        userService.updateUser(userDTO.getId().toString(), userDTO);
        return "redirect:/user/userManagement";
    }

    @PostMapping("/delete")
    public String deleteUser(@ModelAttribute UserDTO userDTO) {
        userService.deleteUser(userDTO.getId().toString());
        return "redirect:/user/userManagement";
    }

//    @PostMapping("/userManagement")
//    public String loginUser(UserDTO userDTO) {
//        User user = userService.findByUserName(userDTO.getUserName());
//
//        if (user != null && user.getPassword().equals(userDTO.getPassword())) {
//            return "userManagement";
//        } else {
//            return "redirect:/login";
//        }
//    }
}
