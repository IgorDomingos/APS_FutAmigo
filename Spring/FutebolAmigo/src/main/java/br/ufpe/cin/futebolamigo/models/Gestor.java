package br.ufpe.cin.futebolamigo.models;

import br.ufpe.cin.futebolamigo.models.Time.Time;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Gestor {
    @Id
    private String cpf;
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
//    @OneToOne
//    @JoinColumn(name = "id_time")
//    private Time time;
}
