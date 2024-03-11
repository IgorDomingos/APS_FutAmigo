package br.ufpe.cin.futebolamigouser.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TimeDTO {

    private String nome;
    private String cpfGestor;
//    private List<JogadorDTO> jogadores;
    private String corP;
    private String corS;

}
