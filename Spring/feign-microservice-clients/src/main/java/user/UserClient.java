package user;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user", url = "http://localhost:8085")
public interface UserClient {

    @GetMapping(path = "user/{id}")
    public ResponseEntity<SecurityProperties.User> getUserById(@PathVariable("id") Long id);
}