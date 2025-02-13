package hcmut.contentCreatorOnline.controller.auth;

import hcmut.contentCreatorOnline.dto.user.LoginUserRequest;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginUserRequest loginUserRequest) throws ApplicationException {
        try {
            String token = userService.verify(loginUserRequest);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (ApplicationException e) {
            throw e;
        }
    }
}
