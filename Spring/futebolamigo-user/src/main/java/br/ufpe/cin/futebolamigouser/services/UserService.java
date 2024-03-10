package br.ufpe.cin.futebolamigouser.services;

import br.ufpe.cin.futebolamigouser.dto.UserDTO;
import br.ufpe.cin.futebolamigouser.models.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    User findByUserName(String username);

    List<UserDTO> findAllUsers();

    UserDTO updateUser(String id, UserDTO userDTO);

    void deleteUser(String id);

    Long getCurrentUserId();
}
