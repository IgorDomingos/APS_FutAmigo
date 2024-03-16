package br.ufpe.cin.futebolamigo.services.impl;

import br.ufpe.cin.futebolamigo.events.UserEvent;
import br.ufpe.cin.futebolamigo.repositories.UserRepository;
import br.ufpe.cin.futebolamigo.dto.UserDTO;
import br.ufpe.cin.futebolamigo.models.User;
import br.ufpe.cin.futebolamigo.mapper.UserMapper;
import br.ufpe.cin.futebolamigo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
//import user.UserClient;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;
    private final ApplicationEventPublisher eventPublisher;
//    private UserClient userClient;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User userToSave = mapper.convertToEntity(userDTO);
        userToSave.setPassword(encoder.encode(userToSave.getPassword()));
        User savedUser = repository.save(userToSave);
        return mapper.convertToDto(savedUser);
    }
//    public void UserService(UserClient userClient) {
//        this.userClient = userClient;
//    }
//
//    public SecurityProperties.User getUserById(Long id) {
//        ResponseEntity<SecurityProperties.User> response = userClient.getUserById(id);
//        return response.getBody();
//    }

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

            // Publicar o UserUpdateEvent -- Observer Pattern
            UserEvent event = new UserEvent(this, mapper.convertToDto(updatedUser));
            eventPublisher.publishEvent(event);

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
    @Override
    public Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = findByUserName(currentUserName);
        return currentUser.getId();
    }
}