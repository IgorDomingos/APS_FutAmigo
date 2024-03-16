package br.ufpe.cin.futebolamigo.models;

import br.ufpe.cin.futebolamigo.decorator.JogadorInterface;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "jogadores")
public class Jogador implements JogadorInterface {
    @Id
    private String cpf;
<<<<<<< HEAD
    private Long time;
=======
    @ManyToOne
    @JoinColumn(name = "nome_time")
    private Time time;
>>>>>>> parent of e93bbb3 (fix, and create docker compose)
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
    private String idade;
    private double peso;
    private double altura;
    private String posicao;

    @Override
    public void updateSkills(String cpf, String skills) {

    }

    @Override
    public void setSkills(String skills) {

    }
}
