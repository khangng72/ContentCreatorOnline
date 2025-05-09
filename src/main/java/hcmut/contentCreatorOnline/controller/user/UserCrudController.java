package hcmut.contentCreatorOnline.controller.user;

import hcmut.contentCreatorOnline.dto.user.*;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    public ResponseEntity<?> getCurrentUser() {
        UserResponseDTO user = userService.getCurrentUser();
        Map<String, Object> response = new HashMap<>();
        response.put("status", 200);
        response.put("result", user);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/followers/{userId}")
    public ResponseEntity<GetFollowersResponse> getFollowersByUserId(
            @PathVariable UUID userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size
    ) {
        List<FollowerDTO> result = userService.getFollowersByUserId(userId, page, size);
        return ResponseEntity.ok(
                GetFollowersResponse.builder()
                        .status(200)
                        .result(result)
                        .build());
    }


    @GetMapping("/following/{userId}")
    public ResponseEntity<GetFollowingResponse> getFollowingByUserId(
            @PathVariable UUID userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size
    ) {
        List<FollowingDTO> result = userService.getFollowingByUserId(userId, page, size);
        return ResponseEntity.ok(GetFollowingResponse.builder()
                .status(200)
                .result(result)
                .build());
    }

    @GetMapping("/search")
    public ResponseEntity<SearchUserResponse> searchUser(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size
    ) {
        List<UserResponseDTO> result = userService.searchUserByKeyword(keyword, page, size);
        return ResponseEntity.ok(new SearchUserResponse(HttpStatus.OK.value(), result));
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateUser(
            @PathVariable UUID userId,
            @RequestBody UpdateUserRequest updateUserRequest
    ) {
        userService.updateUser(userId, updateUserRequest);
        return ResponseEntity.ok("Update user successfully");
    }
}
