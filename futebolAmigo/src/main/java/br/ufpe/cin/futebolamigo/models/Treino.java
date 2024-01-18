package br.ufpe.cin.futebolamigo.models;

import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp dataHorario;
    private String local;
    @ManyToOne
    @JoinColumn(name = "id_time")
    private Time time;
    @ManyToOne
    @JoinColumn(name = "id_localizacao")
    private Local localizacao;
}
