package br.ufpe.cin.futebolamigouser.controllers;// Classe OAuth2Controller
import br.ufpe.cin.futebolamigouser.dto.OAuth2UserDTO;
import br.ufpe.cin.futebolamigouser.services.OAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/oauth2")
public class OAuth2Controller {
    private OAuth2UserService oAuth2UserService;

    @PostMapping("/callback")
    public String handleOAuth2Callback(OAuth2AuthenticationToken token) {
        String name = token.getPrincipal().getAttribute("name");
        String email = token.getPrincipal().getAttribute("email");
        String provider = token.getAuthorizedClientRegistrationId();
        String providerId = token.getPrincipal().getName();

        OAuth2UserDTO oAuth2UserDTO = new OAuth2UserDTO();
        oAuth2UserDTO.setName(name);
        oAuth2UserDTO.setEmail(email);
        oAuth2UserDTO.setProvider(provider);
        oAuth2UserDTO.setProviderId(providerId);

        oAuth2UserService.createOAuth2User(oAuth2UserDTO);

        return "redirect:/";
    }
}