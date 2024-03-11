package br.ufpe.cin.futebolamigouser.models;

import br.ufpe.cin.futebolamigouser.decorator.JogadorInterface;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "jogadores")
public class Jogador implements JogadorInterface {
    @Id
    private String cpf;
    private Long time;
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
