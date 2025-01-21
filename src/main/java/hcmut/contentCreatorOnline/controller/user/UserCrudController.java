package hcmut.contentCreatorOnline.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hcmut.contentCreatorOnline.dto.user.RegisterNewUserRequest;
import hcmut.contentCreatorOnline.dto.user.RegisterNewUserResponse;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.service.UserCrudService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserCrudController {
    @Autowired
    private UserCrudService userCrudService;

    @PostMapping("/register")
    public ResponseEntity<RegisterNewUserResponse> registerNewUser(
            @RequestBody @Valid RegisterNewUserRequest registerNewUserRequest)
            throws ApplicationException {

        try {
            RegisterNewUserResponse response = userCrudService.createNewUser(registerNewUserRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (ApplicationException ex) {
            throw ex;
        }

    }
}
