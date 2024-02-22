package br.ufpe.cin.futebolamigo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class TimeDTO {

    private String nome;
    private String cpfGestor;
    private List<JogadorDTO> jogadores;
    private String corP;
    private String corS;
    private String escudo;

}
