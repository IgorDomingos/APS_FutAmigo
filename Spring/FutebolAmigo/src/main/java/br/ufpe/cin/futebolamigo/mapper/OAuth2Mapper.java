package br.ufpe.cin.futebolamigo.mapper;

import br.ufpe.cin.futebolamigo.dto.OAuth2UserDTO;
import br.ufpe.cin.futebolamigo.models.OAuth2User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OAuth2Mapper {
    private final ModelMapper modelMapper;

    public OAuth2User convertToEntity(OAuth2UserDTO oAuth2UserDTO){
        return modelMapper.map(oAuth2UserDTO, OAuth2User.class);
    }

    public OAuth2UserDTO convertToDto(OAuth2User oAuth2User){
        return modelMapper.map(oAuth2User, OAuth2UserDTO.class);
    }
}