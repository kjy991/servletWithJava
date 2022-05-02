package hello.servlet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
class HealthcheckController {

    Map<String, String> status;
    LocalDateTime now = LocalDateTime.now();


    ResponseEntity OK = new ResponseEntity(HttpStatus.OK);

    @GetMapping(value = "/healthcheck")
    public Map<String, String> healthcheck(@RequestParam("format") String format) {
        if (format == "short") {
            status.put("status", String.valueOf(OK));
            return status;
        } else if (format == "full") {
            status.put("current Time", String.valueOf(now));
            status.put("status", String.valueOf(OK));
            return status;
        } else {
            new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @PutMapping(value = "/healthcheck")
    public ResponseEntity healthcheckPut() {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @PostMapping(value = "/healthcheck")
    public ResponseEntity healthcheckPost() {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }


    @DeleteMapping(value = "/healthcheck")
    public ResponseEntity healthcheckDelete() {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }

}