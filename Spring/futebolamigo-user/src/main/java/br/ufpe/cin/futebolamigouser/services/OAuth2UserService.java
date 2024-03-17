package br.ufpe.cin.futebolamigouser.services;

import br.ufpe.cin.futebolamigouser.dto.OAuth2UserDTO;
import br.ufpe.cin.futebolamigouser.models.OAuth2User;

import java.util.List;

public interface OAuth2UserService {

    OAuth2UserDTO createOAuth2User(OAuth2UserDTO oAuth2UserDTO);

    OAuth2User findByProviderAndProviderId(String provider, String providerId);

    List<OAuth2UserDTO> findAllOAuth2User();

    OAuth2UserDTO updateOAuth2User(String id, OAuth2UserDTO oAuth2UserDTO);

    void deleteOAuth2User(String id);

}