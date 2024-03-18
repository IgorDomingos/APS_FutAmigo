package user;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "jogador", url = "http://localhost:8085")
public interface JogadorClient {

    @GetMapping(path = "jogador/{id}")
    public ResponseEntity<SecurityProperties.User> getJogadorById(@PathVariable("id") Long id);
}