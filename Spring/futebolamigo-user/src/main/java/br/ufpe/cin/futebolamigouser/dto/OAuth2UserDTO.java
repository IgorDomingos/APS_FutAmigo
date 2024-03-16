package br.ufpe.cin.futebolamigo.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OAuth2UserDTO {
    private Long id;
    private String name;
    private String email;
    private String provider;
    private String providerId;

}
