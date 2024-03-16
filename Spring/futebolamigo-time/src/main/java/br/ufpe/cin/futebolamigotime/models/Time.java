package br.ufpe.cin.futebolamigo.models;

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
<<<<<<< HEAD
    private Long gestor;
    @OneToMany
    private List<JogadorDTO> jogador;
    private String corP;
    private String corS;

    public List<JogadorDTO> getJogadores() {
=======
    @OneToOne
    @JoinColumn(name = "cpf_gestor")
    private Gestor gestor;
    @OneToMany(mappedBy = "time")
    private List<Jogador> jogador;
    private String corP;
    private String corS;

    public List<Jogador> getJogadores() {
>>>>>>> parent of e93bbb3 (fix, and create docker compose)
        return this.jogador;
    }
}
