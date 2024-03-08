package br.ufpe.cin.futebolamigo.services;

import br.ufpe.cin.futebolamigo.dto.UserDTO;
import br.ufpe.cin.futebolamigo.models.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    User findByUserName(String username);

    List<UserDTO> findAllUsers();

    UserDTO updateUser(String id, UserDTO userDTO);

    void deleteUser(String id);

    Long getCurrentUserId();
}
