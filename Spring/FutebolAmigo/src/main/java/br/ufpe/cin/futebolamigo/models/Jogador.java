package br.ufpe.cin.futebolamigo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "jogadores")
public class Jogador {
    @Id
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "nome_time")
    private Time time;
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
    private String idade;
    private double peso;
    private double altura;
    private String posicao;
}
