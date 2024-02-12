package br.ufpe.cin.futebolamigo.models;

import br.ufpe.cin.futebolamigo.models.Time.Time;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Gestor {
    @Id
    private String cpf;
    private String nome;
    private String email;
    @OneToOne(mappedBy = "gestor")
    private Time time;
}
