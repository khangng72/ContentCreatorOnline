package hcmut.contentCreatorOnline.controller.user;

import hcmut.contentCreatorOnline.dto.user.*;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.model.UserPrincipal;
import hcmut.contentCreatorOnline.service.UserService;
import hcmut.contentCreatorOnline.utils.SecurityUtils;
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

    @GetMapping("/verify/{user_id}")
    public ResponseEntity<Boolean> verifyIfCurrentUser(
            @PathVariable UUID user_id
    ) {
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        UUID currentUserId = currentUser.getId();

        if (currentUserId.equals(user_id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getCurrentUser() {
        UserResponseDTO user = userService.getCurrentUser();
        Map<String, Object> response = new HashMap<>();
        response.put("status", 200);
        response.put("result", user);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<?> getUserProfile(
            @PathVariable UUID userId
    ) {
        UserResponseDTO user = userService.getUserById(userId);
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

    @GetMapping("/check_if_have_followed/{userId}")
    public ResponseEntity<Boolean> checkIfCurrentUserHaveFollowGivenId(
            @PathVariable UUID userId
    ) {
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        UUID currentUserId = currentUser.getId();

        if (userService.checkIfCurrentUserHaveFollowGivenId(currentUserId, userId)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }

    @PutMapping("/toggleFollow/{userId}")
    public ResponseEntity<Boolean> toggleFollow(@PathVariable UUID userId) {
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        UUID currentUserId = currentUser.getId();

        userService.toggleFollow(currentUserId, userId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/read_preference")
    public ResponseEntity<ReadPreference> getCurrentUserReadingPreference() {
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        UUID currentUserId = currentUser.getId();

        ReadPreference readingPreference = userService.getReadingPreference(currentUserId);
        return ResponseEntity.ok(readingPreference);
    }

    @PutMapping("/read_preference")
    public ResponseEntity<String> updateCurrentUserReadingPreference(
            @RequestBody ReadPreference readPreference
    ) {
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        UUID currentUserId = currentUser.getId();

        userService.updateReadingPreference(currentUserId, readPreference);
        return ResponseEntity.ok("Update reading preference successfully");
    }

    @GetMapping("/write_preference")
    public ResponseEntity<WritePreference> getCurrentUserWritingPreference() {
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        UUID currentUserId = currentUser.getId();

        WritePreference writingPreference = userService.getWritingPreference(currentUserId);
        return ResponseEntity.ok(writingPreference);
    }

    @PutMapping("/write_preference")
    public ResponseEntity<String> updateCurrentUserWritingPreference(
            @RequestBody WritePreference writePreference
    ) {
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        UUID currentUserId = currentUser.getId();

        userService.updateWritingPreference(currentUserId, writePreference);
        return ResponseEntity.ok("Update reading preference successfully");
    }
}
