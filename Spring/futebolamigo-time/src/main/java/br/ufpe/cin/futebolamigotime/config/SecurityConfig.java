package br.ufpe.cin.futebolamigotime.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

import java.util.Collections;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = new User("mike",passwordEncoder().encode("123"), Collections.emptyList());
//        UserDetails user2 = User.builder()
//                .username("Bob")
//                .password(passwordEncoder().encode("124"))
//                .build();
//        return new InMemoryUserDetailsManager(user1,user2);
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(Customizer.withDefaults())
                .authorizeHttpRequests(request->
                        request.requestMatchers("/user/create","/login","/css/**",
                                        "/js/**","/images/**").permitAll()
                                .anyRequest().authenticated())
                .formLogin(form-> form.loginPage("/login")
                        .defaultSuccessUrl("/",true))
                .oauth2Login(oauth2->oauth2
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true))
                .build();

    }
}
