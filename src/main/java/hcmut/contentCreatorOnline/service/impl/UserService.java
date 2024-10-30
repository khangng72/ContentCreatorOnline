package hcmut.contentCreatorOnline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmut.contentCreatorOnline.dto.user.UserAccountDto;
import hcmut.contentCreatorOnline.mapper.IUserMapper;
import hcmut.contentCreatorOnline.model.User.UserAccount;
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
    public List<UserAccount> getAllUser() {
        List<UserAccount> userAccountDtos = userRepository.findAll();
        return userAccountDtos;
    }

    @Override
    @Transactional
    public UserAccountDto createNewUser(UserAccountDto newUserDto) {
        UserAccount entity = mapper.toUserAccount(newUserDto);
        if (entity != null) {
            UserAccountDto savedEntity = mapper.toUserAccountDto(entity);
            return savedEntity;
        } else {
            throw new ElementNotFoundException(UserAccount.class);
        }
    }
}
