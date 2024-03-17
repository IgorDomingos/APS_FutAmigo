package br.ufpe.cin.futebolamigouser.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "oauth2_users")
@Data
public class OAuth2User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private String provider;
    private String providerId;

}