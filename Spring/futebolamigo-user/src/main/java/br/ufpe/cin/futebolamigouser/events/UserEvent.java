package br.ufpe.cin.futebolamigouser.events;

import br.ufpe.cin.futebolamigouser.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class UserEvent extends ApplicationEvent {
    private UserDTO userDTO;

    public UserEvent(Object source, UserDTO userDTO) {
        super(source);
        this.userDTO = userDTO;
    }

}