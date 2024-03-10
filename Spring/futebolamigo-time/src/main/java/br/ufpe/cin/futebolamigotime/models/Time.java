package br.ufpe.cin.futebolamigotime.models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "times")
public class Time {
    @Id
    private String nome;
//    @OneToOne
//    @JoinColumn(name = "cpf_gestor")
//    private Gestor gestor;
//    @OneToMany(mappedBy = "time")
//    private List<Jogador> jogador;
    private String corP;
    private String corS;

//    public List<Jogador> getJogadores() {
//        return this.jogador;
//    }
}
