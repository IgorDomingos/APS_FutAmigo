package br.ufpe.cin.futebolamigo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GestorDTO {

    private String cpf;
    private String nome;
    private String email;

    // Opcional: ID do time (simplificado)
    private Long timeId;

    // Construtor com todos os campos (opcional)
    public GestorDTO(String cpf, String nome, String email, Long timeId) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.timeId = timeId;
    }

}
