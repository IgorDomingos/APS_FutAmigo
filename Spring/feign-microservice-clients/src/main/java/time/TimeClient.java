package time;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Time;

@FeignClient(value = "time", url = "http://localhost:8081")
public interface TimeClient {

    @GetMapping(path = "/time/{id}")
    public ResponseEntity<Time> getTimeById(@PathVariable("id") Long id);
}