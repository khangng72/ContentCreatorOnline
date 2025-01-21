package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.user.RegisterNewUserRequest;
import hcmut.contentCreatorOnline.dto.user.RegisterNewUserResponse;
import hcmut.contentCreatorOnline.exception.ApplicationException;

public interface UserCrudService {
    public RegisterNewUserResponse createNewUser(RegisterNewUserRequest user) throws ApplicationException;
}
