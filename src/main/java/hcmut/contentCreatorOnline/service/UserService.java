package hcmut.contentCreatorOnline.service;

import org.springframework.stereotype.Service;

import hcmut.contentCreatorOnline.dto.user.LoginUserRequest;
import hcmut.contentCreatorOnline.dto.user.RegisterNewUserRequest;
import hcmut.contentCreatorOnline.dto.user.RegisterNewUserResponse;
import hcmut.contentCreatorOnline.exception.ApplicationException;

@Service
public interface UserService {
    public String verify(LoginUserRequest user);

    public RegisterNewUserResponse createNewUser(RegisterNewUserRequest user) throws ApplicationException;
}
