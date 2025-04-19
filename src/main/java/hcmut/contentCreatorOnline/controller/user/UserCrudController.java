package hcmut.contentCreatorOnline.controller.user;

import hcmut.contentCreatorOnline.dto.user.RegisterNewUserRequest;
import hcmut.contentCreatorOnline.dto.user.RegisterNewUserResponse;
import hcmut.contentCreatorOnline.dto.user.UserResponseDTO;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserCrudController {
    private final UserService userService;

    public UserCrudController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterNewUserResponse> registerNewUser(
            @RequestBody @Valid RegisterNewUserRequest registerNewUserRequest)
            throws ApplicationException {

        RegisterNewUserResponse response = userService.createNewUser(registerNewUserRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getUserById() {
        UserResponseDTO user = userService.getUserById();
        Map<String, Object> response = new HashMap<>();
        response.put("status", 200);
        response.put("result", user);
        return ResponseEntity.ok(response);
    }
}
