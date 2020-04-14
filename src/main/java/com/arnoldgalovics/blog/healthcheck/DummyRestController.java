package com.arnoldgalovics.blog.healthcheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyRestController {
    private static final Logger logger = LoggerFactory.getLogger(DummyRestController.class);

    @GetMapping(value = "/dummy", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> dummy() {
        logger.info("Dummy call");
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
