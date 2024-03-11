package time;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "time")
public interface TimeClient {

    @GetMapping("/time/{id}")
    ResponseEntity<Time> getTimeById(@PathVariable String id);

}