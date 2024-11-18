package hcmut.contentCreatorOnline.service.impl;

import java.util.List;

import hcmut.contentCreatorOnline.dto.user.CCOUserDTO;
import hcmut.contentCreatorOnline.model.CCO_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmut.contentCreatorOnline.mapper.IUserMapper;
import hcmut.contentCreatorOnline.repository.user.UserRepository;
import hcmut.contentCreatorOnline.service.IUserService;
import hcmut.contentCreatorOnline.service.exception.ElementNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserMapper mapper;

    @Override
    public List<CCO_User> getAllUser() {
        List<CCO_User> CCOUserDtos = userRepository.findAll();
        return CCOUserDtos;
    }

    @Override
    @Transactional
    public CCOUserDTO createNewUser(CCOUserDTO newUserDto) {
        CCO_User entity = mapper.toUserAccount(newUserDto);
        if (entity != null) {
            CCOUserDTO savedEntity = mapper.toUserAccountDto(entity);
            return savedEntity;
        } else {
            throw new ElementNotFoundException(CCO_User.class);
        }
    }


}
