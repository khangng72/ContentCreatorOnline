package hcmut.contentCreatorOnline.service.impl;

import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.User;
import hcmut.contentCreatorOnline.model.UserPrincipal;
import hcmut.contentCreatorOnline.repository.UserRepository;
import hcmut.contentCreatorOnline.utils.LoggerUtil;
import org.slf4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerUtil.getLogger(CustomUserDetailsService.class);
    
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws ApplicationException {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            logger.info("User does not exist !");
            throw new ApplicationException(ErrorConst.UNAUTHORIZED, "User does not exist");
        }

        return new UserPrincipal(user);
    }

}
