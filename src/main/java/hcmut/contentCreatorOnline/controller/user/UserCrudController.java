package hcmut.contentCreatorOnline.controller.user;

import hcmut.contentCreatorOnline.dto.user.RegisterNewUserRequest;
import hcmut.contentCreatorOnline.dto.user.RegisterNewUserResponse;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
