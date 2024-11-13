package hcmut.contentCreatorOnline.service;

import java.util.List;

import hcmut.contentCreatorOnline.dto.user.UserAccountDto;
import hcmut.contentCreatorOnline.model.UserAccount;

public interface IUserService {
    List<UserAccount> getAllUser();

    UserAccountDto createNewUser(UserAccountDto newUser) throws Exception;
}
