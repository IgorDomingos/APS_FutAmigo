package br.ufpe.cin.futebolamigouser.events;
import br.ufpe.cin.futebolamigouser.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AnotherUserEventListener implements Observer {
    private static final Logger logger = LoggerFactory.getLogger(AnotherUserEventListener.class);

    public AnotherUserEventListener(Subject subject) {
        subject.subscribe(this);
    }

    @Override
    public void update(UserEvent event) {
        UserDTO updatedUser = event.getUserDTO();
        logger.info("Another User Event handled with UserDTO: {}", updatedUser);
    }
}