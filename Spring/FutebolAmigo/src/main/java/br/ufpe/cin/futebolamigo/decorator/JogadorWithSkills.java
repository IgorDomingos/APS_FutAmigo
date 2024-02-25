package br.ufpe.cin.futebolamigo.decorator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JogadorWithSkills extends JogadorDecorator {
    private String skills;

    public JogadorWithSkills(JogadorInterface jogador, String skills) {
        super(jogador);
        this.skills = skills;
    }

}
