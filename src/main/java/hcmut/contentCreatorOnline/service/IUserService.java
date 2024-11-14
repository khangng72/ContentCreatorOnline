package hcmut.contentCreatorOnline.service;

import java.util.List;

import hcmut.contentCreatorOnline.dto.user.UserAccountDto;
import hcmut.contentCreatorOnline.model.CCO_User;

public interface IUserService {
    List<CCO_User> getAllUser();

    UserAccountDto createNewUser(UserAccountDto newUser) throws Exception;
}
