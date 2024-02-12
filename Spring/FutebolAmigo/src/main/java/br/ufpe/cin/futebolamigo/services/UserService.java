package br.ufpe.cin.futebolamigo.services;

import br.ufpe.cin.futebolamigo.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> findAllUsers();
}
