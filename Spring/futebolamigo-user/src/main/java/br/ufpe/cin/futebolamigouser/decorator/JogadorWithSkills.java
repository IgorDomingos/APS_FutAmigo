package br.ufpe.cin.futebolamigo.decorator;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JogadorWithSkills extends JogadorDecorator {
    private String skills;

    public JogadorWithSkills(JogadorInterface jogador, String skills) {
        super(jogador);
        this.skills = skills;
    }

    @Override
    public void updateSkills(String cpf, String skills) {
        if (this.getCpf().equals(cpf)) {
            this.setSkills(skills);
        }
    }
}
