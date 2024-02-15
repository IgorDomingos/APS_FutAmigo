package br.ufpe.cin.futebolamigo.events;
import br.ufpe.cin.futebolamigo.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateEventListener {
    private static final Logger logger = LoggerFactory.getLogger(UserUpdateEventListener.class);
    @EventListener
    public void handleUserUpdateEvent(UserUpdateEvent event) {
        UserDTO updatedUser = event.getUserDTO();
        logger.info("UserUpdateEvent handled with UserDTO: {}", updatedUser);
    }
}