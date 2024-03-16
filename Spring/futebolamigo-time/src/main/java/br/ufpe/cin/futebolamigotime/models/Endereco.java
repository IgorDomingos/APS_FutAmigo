package br.ufpe.cin.futebolamigo.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String rua;
    private String numero;
    private String cep;
    private String complemento;
    private String cidade;
    private String estado;
}
