package user;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "jogador")
public interface JogadorClient {

    @GetMapping(path = "api/v1/jogador/{id}")
    public ResponseEntity<SecurityProperties.User> getJogadorById(@PathVariable("id") Long id);
}