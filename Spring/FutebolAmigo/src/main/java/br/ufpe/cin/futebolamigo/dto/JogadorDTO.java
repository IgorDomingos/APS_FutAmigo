package br.ufpe.cin.futebolamigo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class JogadorDTO {

    private String cpf;
    private String nome;
    private String email;

    // DTO para Time com apenas o ID (simplificado)
//    private Long timeId;

    private Date idade;
    private Double peso;
    private Double altura;
    private String posicao;

//    // Construtor com todos os campos (opcional)
//    public JogadorDTO(String cpf, String nome, String email, Long timeId, Date idade, Double peso, Double altura, String posicao) {
//        this.cpf = cpf;
//        this.nome = nome;
//        this.email = email;
//        this.timeId = timeId;
//        this.idade = idade;
//        this.peso = peso;
//        this.altura = altura;
//        this.posicao = posicao;
//    }
}
