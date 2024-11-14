package hcmut.contentCreatorOnline.controller;

import java.util.List;

import hcmut.contentCreatorOnline.model.CCO_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hcmut.contentCreatorOnline.dto.user.UserAccountDto;
import hcmut.contentCreatorOnline.dto.user.UserRegisterRequestDto;
import hcmut.contentCreatorOnline.service.IUserService;
import hcmut.contentCreatorOnline.service.impl.UserAcctService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService service;

    @GetMapping("/all")
    public List<CCO_User> getAllUsers() {
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

    // khoa register
    @Autowired
    private UserAcctService userAcctService;

    @PostMapping("/register")
    public String register(@RequestBody UserRegisterRequestDto request) {
        return userAcctService.registerUser(request);
    }

    @GetMapping("/login")
    public String login() {
        return userAcctService.getUser();
    }

}
