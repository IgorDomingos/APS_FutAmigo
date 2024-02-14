package br.ufpe.cin.futebolamigo.services.impl;

import br.ufpe.cin.futebolamigo.repositories.UserRepository;
import br.ufpe.cin.futebolamigo.dto.UserDTO;
import br.ufpe.cin.futebolamigo.models.User;
import br.ufpe.cin.futebolamigo.mapper.UserMapper;
import br.ufpe.cin.futebolamigo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User userToSave = mapper.convertToEntity(userDTO);
        userToSave.setPassword(encoder.encode(userToSave.getPassword()));
        User savedUser = repository.save(userToSave);
        return mapper.convertToDto(savedUser);
    }

    @Override
    public User findByUserName(String username) {
        return repository.findByUserName(username);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> users = repository.findAll();
        return users.stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(String id, UserDTO userDTO) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setUserName(userDTO.getUserName());
            User updatedUser = repository.save(user);

            return mapper.convertToDto(updatedUser);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    @Override
    public void deleteUser(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}