package br.ufpe.cin.futebolamigo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
public class JogadorDTO {

    private String cpf;
    private String timeId;
    private String userId;
    private Date idade;
    private Double peso;
    private Double altura;
    private String posicao;

}
