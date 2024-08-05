package com.app.gym;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class MenuController {
    @GetMapping("/menu")
    public ResponseEntity<?> showMenu() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Hello World");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
