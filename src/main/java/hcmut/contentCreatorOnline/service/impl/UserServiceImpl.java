package hcmut.contentCreatorOnline.service.impl;

import hcmut.contentCreatorOnline.dto.user.LoginUserRequest;
import hcmut.contentCreatorOnline.dto.user.RegisterNewUserRequest;
import hcmut.contentCreatorOnline.dto.user.RegisterNewUserResponse;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.User;
import hcmut.contentCreatorOnline.repository.UserRepository;
import hcmut.contentCreatorOnline.service.JwtService;
import hcmut.contentCreatorOnline.service.UserService;
import hcmut.contentCreatorOnline.utils.LoggerUtil;
import hcmut.contentCreatorOnline.utils.PasswordUtil;
import org.slf4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerUtil.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordUtil passwordUtil;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserServiceImpl(UserRepository userRepository, PasswordUtil passwordUtil, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordUtil = passwordUtil;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String verify(LoginUserRequest user) throws ApplicationException {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

            if (authentication.isAuthenticated()) {
                logger.info("Get jwt token successfully");
                return jwtService.generateToken(user.getEmail());
            }
            return null;

        } catch (AuthenticationException ex) {
            logger.error("Authentication failed: {}", ex.getMessage());
            throw new ApplicationException(ErrorConst.UNAUTHORIZED, "Unauthorized");
        }
    }

    @Override
    public RegisterNewUserResponse createNewUser(RegisterNewUserRequest user) throws ApplicationException {

        try {
            User userWithEmail = userRepository.findByEmail(user.getEmail());

            if (userWithEmail != null) {
                logger.error("User with email {} is already exist", userWithEmail.getEmail());
                throw new ApplicationException(ErrorConst.RESOURCE_EXIST, "Email is exist");
            }

            logger.info("Start adding user with email {}", user.getEmail());

            // hash plain password
            String hashedPassword = passwordUtil.encode(user.getPassword());

            // construct new User
            User newUser = User.builder()
                    .email(user.getEmail())
                    .password(hashedPassword)
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .gender(user.getGender())
                    .nationality(user.getNationality())
                    .birthday(user.getBirthday())
                    .build();

            User queryResult = userRepository.save(newUser);
            logger.info("Finish adding user with email {}", queryResult.getEmail());

            return RegisterNewUserResponse.builder()
                    .email(queryResult.getEmail())
                    .firstName(queryResult.getFirstName())
                    .lastName(queryResult.getLastName())
                    .gender(queryResult.getGender())
                    .isAdmin(queryResult.isAdmin())
                    .nationality(queryResult.getNationality())
                    .birthday(queryResult.getBirthday())
                    .build();

        } catch (ApplicationException e) {

            throw e;

        } catch (RuntimeException e) {

            logger.error("Cannot create user with email {}", user.getEmail());
            throw new ApplicationException(ErrorConst.UNEXPECTED_ERROR);
        }
    }

}
