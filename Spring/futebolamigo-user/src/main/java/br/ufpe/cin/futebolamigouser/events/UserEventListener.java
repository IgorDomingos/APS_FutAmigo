package br.ufpe.cin.futebolamigouser.events;
import br.ufpe.cin.futebolamigouser.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {
    private static final Logger logger = LoggerFactory.getLogger(UserEventListener.class);
    @EventListener
    public void handleUserEvent(UserEvent event) {
        UserDTO updatedUser = event.getUserDTO();
        logger.info("User Event handled with UserDTO: {}", updatedUser);
    }
}