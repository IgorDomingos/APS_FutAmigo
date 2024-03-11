package br.ufpe.cin.futebolamigotime.models;

import br.ufpe.cin.futebolamigotime.dto.JogadorDTO;
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
    private Long gestor;
    @OneToMany
    private List<JogadorDTO> jogador;
    private String corP;
    private String corS;

    public List<JogadorDTO> getJogadores() {
        return this.jogador;
    }
}
