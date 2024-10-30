package hcmut.contentCreatorOnline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hcmut.contentCreatorOnline.dto.user.UserRegisterRequest;
import hcmut.contentCreatorOnline.model.User.UserAccount;
import hcmut.contentCreatorOnline.repository.user.UserRepository;

@Service
public class UserAcctService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(UserRegisterRequest request) {
        if (userRepository.findUserAccountByEmail(request.getEmail()).isPresent()) {
            return "Email đã tồn tại!";
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
        return "Đăng ký thành công!";
    }
}
