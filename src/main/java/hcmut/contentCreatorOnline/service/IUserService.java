package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.user.UserAccountDto;
import hcmut.contentCreatorOnline.model.User.UserAccount;

import java.util.List;


public interface IUserService {
    List<UserAccount> getAllUser();

    UserAccountDto createNewUser(UserAccountDto newUser) throws Exception;
}
