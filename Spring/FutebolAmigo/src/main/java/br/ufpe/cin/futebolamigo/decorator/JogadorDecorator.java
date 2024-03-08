package br.ufpe.cin.futebolamigo.decorator;

import br.ufpe.cin.futebolamigo.models.Time;
import br.ufpe.cin.futebolamigo.models.User;

public abstract class JogadorDecorator implements JogadorInterface {
    protected JogadorInterface jogador;

    public JogadorDecorator(JogadorInterface jogador) {
        this.jogador = jogador;
    }

    @Override
    public String getCpf() {
        return jogador.getCpf();
    }

    @Override
    public Time getTime() {
        return jogador.getTime();
    }

    @Override
    public User getUser() {
        return jogador.getUser();
    }

    @Override
    public String getIdade() {
        return jogador.getIdade();
    }

    @Override
    public double getPeso() {
        return jogador.getPeso();
    }

    @Override
    public double getAltura() {
        return jogador.getAltura();
    }

    @Override
    public String getPosicao() {
        return jogador.getPosicao();
    }
}