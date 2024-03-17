package br.ufpe.cin.futebolamigouser.services.impl;

import br.ufpe.cin.futebolamigouser.repositories.UserRepository;
import br.ufpe.cin.futebolamigouser.dto.CustomUserDetails;
import br.ufpe.cin.futebolamigouser.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SecurityService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = userRepository.findByUserName(username);
        if (foundUser == null){
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(foundUser);
    }









}
