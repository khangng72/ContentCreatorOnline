package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.user.*;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {
    String verify(LoginUserRequest user);

    RegisterNewUserResponse createNewUser(RegisterNewUserRequest user) throws ApplicationException;

    UserResponseDTO getCurrentUser();

    List<FollowerDTO> getFollowersByUserId(UUID userId, int page, int size);

    List<FollowingDTO> getFollowingByUserId(UUID userId, int page, int size);

    List<UserResponseDTO> searchUserByKeyword(String keyword, int page, int size);

    void updateUser(UUID userId, UpdateUserRequest updateUserRequest);

    UserResponseDTO getUserById(UUID userId);

    boolean checkIfCurrentUserHaveFollowGivenId(UUID currentUserId, UUID userId);

    void toggleFollow(UUID currentUserId, UUID userId);
}