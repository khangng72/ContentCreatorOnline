package hcmut.contentCreatorOnline.service;

import java.util.List;

import hcmut.contentCreatorOnline.dto.user.CCOUserDTO;
import hcmut.contentCreatorOnline.model.CCO_User;

public interface IUserService {
    List<CCO_User> getAllUser();

    CCOUserDTO createNewUser(CCOUserDTO newUser) throws Exception;
}
