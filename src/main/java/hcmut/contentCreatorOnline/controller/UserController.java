package hcmut.contentCreatorOnline.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hcmut.contentCreatorOnline.dto.user.CreateUserRequest;
import hcmut.contentCreatorOnline.dto.user.CreateUserResponse;
import hcmut.contentCreatorOnline.dto.user.CreateUserResult;
import hcmut.contentCreatorOnline.model.User.CCO_User;
import hcmut.contentCreatorOnline.service.impl.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.UUID;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<CCO_User> getAllUsers() {
        return userService.getAllUser();
    }

    @PostMapping("/add")
    public ResponseEntity<CreateUserResponse> createNewUser(@RequestBody CreateUserRequest createUserRequest) {
        // parse request to CCO_User
        CCO_User newUser = new CCO_User();
        newUser.setUser_id(UUID.randomUUID());
        newUser.setFirst_name(createUserRequest.getFirst_name());
        newUser.setLast_name(createUserRequest.getLast_name());
        newUser.setGender(createUserRequest.getGender());
        newUser.setUser_password(createUserRequest.getUser_password());
        newUser.setBirthday(createUserRequest.getBirthday());
        newUser.setNationality(createUserRequest.getNationality());
        newUser.setEmail(createUserRequest.getEmail());
        newUser.setIs_admin(createUserRequest.isIs_admin());
        // set address ?

        try {
            Optional<CCO_User> result = userService.createNewUser(newUser);

            if (result.isPresent()) {
                CCO_User realResult = result.get();
                CreateUserResult createdUser = new CreateUserResult(
                        realResult.getUser_id(),
                        realResult.getFirst_name(),
                        realResult.getLast_name(),
                        realResult.getGender(),
                        realResult.getBirthday(),
                        realResult.getNationality(),
                        realResult.getEmail(),
                        realResult.isIs_admin());

                CreateUserResponse response = new CreateUserResponse(
                        HttpStatus.CREATED.value(),
                        createdUser,
                        HttpStatus.CREATED.toString());

                return new ResponseEntity<>(response, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            System.out.println("ERROR XXXX: " + e.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/{user_id}")
    public Optional<CCO_User> getUserById(@PathVariable UUID user_id) {
        return userService.findUserById(user_id);
    }

    @PutMapping("/{user_id}")
    public String putMethodName(@PathVariable String id, @RequestBody String entity) {
        // TODO: process PUT request

        return entity;
    }

}
