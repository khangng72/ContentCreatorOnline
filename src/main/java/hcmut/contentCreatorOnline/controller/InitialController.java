package hcmut.contentCreatorOnline.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class InitialController {

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> getInitial() {

        Map<String, String> response = new HashMap<>();
        response.put("message:", "SERVER IS HEALTHY");
        response.put("status:", HttpStatus.OK.toString());

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/session")
    public String getSessionId(HttpServletRequest request) {
        return "Session ID: " + request.getSession().getId();
    }

    @GetMapping("/csrf_token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
