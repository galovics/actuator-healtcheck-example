package com.arnoldgalovics.blog.healthcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManualHealthRestController {
    @Autowired
    private ManualHealthHolder manualHealthHolder;

    @GetMapping("/switch")
    public ResponseEntity<?> switchHealth() {
        manualHealthHolder.switchHealth();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
