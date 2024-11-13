package hcmut.contentCreatorOnline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hcmut.contentCreatorOnline.dto.user.UserRegisterRequestDto;
import hcmut.contentCreatorOnline.model.UserAccount;
import hcmut.contentCreatorOnline.repository.user.UserRepository;

@Service
public class UserAcctService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // handle register for user
    public String registerUser(UserRegisterRequestDto request) {
        if (userRepository.findUserAccountByEmail(request.getEmail()).isPresent()) {
            return "Email is existed!";
        }

        UserAccount user = new UserAccount();
        user.setFirst_name(request.getFirst_name());
        user.setLast_name(request.getLast_name());
        user.setGender(request.getGender());
        user.setUser_password(passwordEncoder.encode(request.getUser_password()));
        user.setBirthday(request.getBirthday());
        user.setNationality(request.getNationality());
        user.setEmail(request.getEmail());
        user.setAddress(request.getAddress());

        userRepository.save(user);
        return "Register successful!";
    }

    public String getUser() {

        return "Login successful";
    }

}
