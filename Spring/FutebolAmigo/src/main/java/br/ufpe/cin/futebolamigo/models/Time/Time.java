package br.ufpe.cin.futebolamigo.models.Time;

import br.ufpe.cin.futebolamigo.models.Gestor;
import br.ufpe.cin.futebolamigo.models.Jogador;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "times")
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToOne
    @JoinColumn(name = "id_gestor")
    private Gestor gestor;
    @OneToMany(mappedBy = "time")
    private List<Jogador> jogador;
    private String corP;
    private String corS;
    private String escudo;
}
