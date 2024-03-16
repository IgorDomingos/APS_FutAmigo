package br.ufpe.cin.futebolamigo.models;

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
<<<<<<< HEAD
    private Long time;
=======
    @OneToOne
    @JoinColumn(name = "nome_time")
    private Time time;
>>>>>>> parent of e93bbb3 (fix, and create docker compose)
}
