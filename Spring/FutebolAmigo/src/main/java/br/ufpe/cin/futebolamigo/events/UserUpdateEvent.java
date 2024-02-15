package br.ufpe.cin.futebolamigo.events;

import br.ufpe.cin.futebolamigo.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class UserUpdateEvent extends ApplicationEvent {
    private UserDTO userDTO;

    public UserUpdateEvent(Object source, UserDTO userDTO) {
        super(source);
        this.userDTO = userDTO;
    }

}