package user;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "gestor", url = "http://localhost:8085")
public interface GestorClient {

    @GetMapping(path = "gestor/{id}")
    public ResponseEntity<SecurityProperties.User> getGestorById(@PathVariable("id") Long id);
}