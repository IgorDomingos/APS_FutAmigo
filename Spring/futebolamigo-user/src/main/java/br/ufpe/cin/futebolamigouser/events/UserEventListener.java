package br.ufpe.cin.futebolamigo.events;
import br.ufpe.cin.futebolamigo.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener implements Observer {
    private static final Logger logger = LoggerFactory.getLogger(UserEventListener.class);

    public UserEventListener(Subject subject) {
        subject.subscribe(this);
    }

    @Override
    public void update(UserEvent event) {
        UserDTO updatedUser = event.getUserDTO();
        logger.info("User Event handled with UserDTO: {}", updatedUser);
    }
}