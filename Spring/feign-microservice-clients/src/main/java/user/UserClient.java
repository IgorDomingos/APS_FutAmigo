package user;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user")
public interface UserClient {

    @GetMapping(path = "api/v1/user/{id}")
    public ResponseEntity<SecurityProperties.User> getUserById(@PathVariable("id") Long id);
}