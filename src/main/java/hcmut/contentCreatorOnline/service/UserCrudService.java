package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.user.AddressUpdateRequest;
import hcmut.contentCreatorOnline.dto.user.RegisterNewUserRequest;
import hcmut.contentCreatorOnline.dto.user.RegisterNewUserResponse;
import hcmut.contentCreatorOnline.dto.user.UpdateUserDTO;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserCrudService {
    public RegisterNewUserResponse createNewUser(RegisterNewUserRequest user) throws ApplicationException;
    public List<User> getAllUser();
    Optional<User> getUserById(UUID userId);
//    public void updateUserAddress(UUID userId, AddressUpdateRequest request);
    User updateUser(UUID userId, UpdateUserDTO request);
    String deleteUser(UUID userId);
}
