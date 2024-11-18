package hcmut.contentCreatorOnline.service.impl;

import hcmut.contentCreatorOnline.dto.user.CCOUserDTO;
import hcmut.contentCreatorOnline.repository.user.Cco_userEntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hcmut.contentCreatorOnline.dto.user.UserRegisterRequestDto;
import hcmut.contentCreatorOnline.model.CCO_User;
import hcmut.contentCreatorOnline.repository.user.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserAcctService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Cco_userEntityManager ccoUserEntityManager;

    // handle register for user
    public String registerUser(UserRegisterRequestDto request) {
        if (userRepository.findUserAccountByEmail(request.getEmail()).isPresent()) {
            return "Email is existed!";
        }

        CCO_User user = new CCO_User();
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

    public List<CCOUserDTO> getCcoUser(String gender){

        List<CCOUserDTO> ccoUserDTOArrayList = new ArrayList<>();
        for (Object[] row : ccoUserEntityManager.getCCOUser(gender)) {
            CCOUserDTO user = new CCOUserDTO();
            user.setAddress((String) row[0]);  // Cột 1: id
            Date birthday = (Date) row[1];  // Cột 2: birthday (java.sql.Date)
            if (birthday != null) {
                user.setBirthday(birthday);  // Chuyển đổi sang String
            } else {
                user.setBirthday(null);  // Nếu không có ngày sinh, gán null
            }  // Cột 2: username
            user.setEmail((String) row[2]);
            user.setFirst_name((String) row[3]);// Cột 3: email
            ccoUserDTOArrayList.add(user);
        }
        return ccoUserDTOArrayList;
    }
}
