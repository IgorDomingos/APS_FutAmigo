package br.ufpe.cin.futebolamigo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String confirmPassword;
}
