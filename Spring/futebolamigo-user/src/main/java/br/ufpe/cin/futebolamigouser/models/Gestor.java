package br.ufpe.cin.futebolamigouser.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Gestor {
    @Id
    private String cpfGestor;
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
    private Long time;
}