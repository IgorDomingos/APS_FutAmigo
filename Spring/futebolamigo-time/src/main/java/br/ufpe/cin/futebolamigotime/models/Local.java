package br.ufpe.cin.futebolamigotime.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Local {
    @Id
    private String nome;
    @Embedded
    private Endereco endereco;
    @OneToMany(mappedBy = "localizacao")
    private List<Treino> treino;
}
