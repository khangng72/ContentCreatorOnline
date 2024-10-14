package hcmut.contentCreatorOnline.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import hcmut.contentCreatorOnline.model.User.CCO_User;
import hcmut.contentCreatorOnline.repository.UserRepository;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<CCO_User> getAllUser() {
        return userRepository.findAll();
    }

    public CCO_User createNewUser(CCO_User newUser) {
        userRepository.createNewUser(
                newUser.getUser_id(),
                newUser.getFirst_name(),
                newUser.getLast_name(),
                newUser.getGender(),
                newUser.getUser_password(),
                newUser.getBirthday(),
                newUser.getNationality(),
                newUser.getEmail(),
                newUser.isIs_admin());
        return newUser;
    }

    public Optional<CCO_User> findUserById(UUID user_id) {
        return userRepository.findUserById(user_id);
    }
}
