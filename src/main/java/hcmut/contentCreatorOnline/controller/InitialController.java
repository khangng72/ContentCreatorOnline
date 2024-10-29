package hcmut.contentCreatorOnline.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class InitialController {

    @GetMapping
    private ResponseEntity<Map<String, String>> getInitial() {
        Map<String, String> response = new HashMap<>();
        response.put("message:", "SERVER IS HEALTHY");
        response.put("status:", HttpStatus.OK.toString());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
