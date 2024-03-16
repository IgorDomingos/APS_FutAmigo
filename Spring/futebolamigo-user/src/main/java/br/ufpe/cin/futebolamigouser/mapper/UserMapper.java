package br.ufpe.cin.futebolamigo.mapper;

import br.ufpe.cin.futebolamigo.dto.UserDTO;
import br.ufpe.cin.futebolamigo.models.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    public User convertToEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }
    public UserDTO convertToDto(User user){
        return modelMapper.map(user, UserDTO.class);
    }

}