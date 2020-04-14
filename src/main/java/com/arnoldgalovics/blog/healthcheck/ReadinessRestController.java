package com.arnoldgalovics.blog.healthcheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadinessRestController {
    private static final Logger logger = LoggerFactory.getLogger(ReadinessRestController.class);

    @Autowired
    private ReadinessHolder readinessHolder;

    @GetMapping(value = "/ready", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> isReady() {
        if (readinessHolder.isReady()) {
            return new ResponseEntity<>("{\"status\":\"READY\"}", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("{\"status\":\"NOT_READY\"}", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @GetMapping("/readyswitch")
    public ResponseEntity<?> readySwitch() {
        readinessHolder.switchReady();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
