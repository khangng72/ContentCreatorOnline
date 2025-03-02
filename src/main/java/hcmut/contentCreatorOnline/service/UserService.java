package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.user.LoginUserRequest;
import hcmut.contentCreatorOnline.dto.user.RegisterNewUserRequest;
import hcmut.contentCreatorOnline.dto.user.RegisterNewUserResponse;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String verify(LoginUserRequest user);

    RegisterNewUserResponse createNewUser(RegisterNewUserRequest user) throws ApplicationException;
}
