package br.ufpe.cin.futebolamigotime.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
public class JogadorDTO {
    @Id
    private String cpf;

}
