package hcmut.contentCreatorOnline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hcmut.contentCreatorOnline.dto.user.UserAccountDto;
import hcmut.contentCreatorOnline.dto.user.UserRegisterRequest;
import hcmut.contentCreatorOnline.model.User.UserAccount;
import hcmut.contentCreatorOnline.service.IUserService;
import hcmut.contentCreatorOnline.service.impl.UserAcctService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService service;

    @GetMapping("/all")
    public List<UserAccount> getAllUsers() {
        return service.getAllUser();
    }

    @PostMapping("/add")
    public ResponseEntity<UserAccountDto> createNewUser(@RequestBody UserAccountDto userAccountDto) {
        try {
            UserAccountDto userAccount = service.createNewUser(userAccountDto);
            return new ResponseEntity<>(userAccount, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Autowired
    private UserAcctService userAcctService;

    @PostMapping("/register")
    public String postMethodName(@RequestBody String entity) {
        // TODO: process POST request

        return entity;
    }

    public String register(@RequestBody UserRegisterRequest request) {
        return userAcctService.registerUser(request);
    }
}
