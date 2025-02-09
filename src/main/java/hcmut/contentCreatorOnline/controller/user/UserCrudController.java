package hcmut.contentCreatorOnline.controller.user;

import hcmut.contentCreatorOnline.dto.user.AddressUpdateRequest;
import hcmut.contentCreatorOnline.dto.user.UpdateUserDTO;
import hcmut.contentCreatorOnline.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hcmut.contentCreatorOnline.dto.user.RegisterNewUserRequest;
import hcmut.contentCreatorOnline.dto.user.RegisterNewUserResponse;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.service.UserCrudService;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    //Get information of all user
    @GetMapping("/all/v1")
    public List<User> getAllUser(){
        return userCrudService.getAllUser();
    }

    @GetMapping("/{userId}")
    public Optional<User> getUserById (@PathVariable UUID userId){
        return userCrudService.getUserById(userId);
    }


    @PutMapping("/{userId}")
    public User updateUser(@PathVariable UUID userId, @RequestBody UpdateUserDTO request){
        return userCrudService.updateUser(userId,request);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable UUID userId){
        return userCrudService.deleteUser(userId);
    }

//    @PostMapping("/{userId}/address/v1")
//    public ResponseEntity<String> updateAddress(
//            @PathVariable UUID userId,
//            @RequestBody AddressUpdateRequest request
//            ){
//        try{
//            userCrudService.updateUserAddress(userId, request);
//            return ResponseEntity.ok("Address updated successfully.");
//        }catch(Exception e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error updating address: " + e.getMessage());
//        }
//    }

}
