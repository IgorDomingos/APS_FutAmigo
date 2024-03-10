package br.ufpe.cin.futebolamigouser.dto;

import br.ufpe.cin.futebolamigouser.models.User;
import br.ufpe.cin.futebolamigouser.services.impl.Prototype;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO implements Prototype {

    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String confirmPassword;

    private UserDTO(UserDTO userDTO) {
        this.id = userDTO.id;
        this.firstName = userDTO.firstName;
        this.lastName = userDTO.lastName;
        this.userName = userDTO.userName;
        this.password = userDTO.password;
        this.confirmPassword = userDTO.confirmPassword;
    }
    public UserDTO() {
    }

    @Override
    public Prototype clone() {
        return new UserDTO(this);
    }
}
