package br.ufpe.cin.futebolamigo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "jogadores")
public class Jogador {
    @Id
    private String cpf;
    private String nome;
    private String email;
    @ManyToOne
    @JoinColumn(name = "id_time")
    private Time time;
    private Date idade;
    private double peso;
    private double altura;
    private String posicao;
}
