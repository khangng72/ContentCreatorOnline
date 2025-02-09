package hcmut.contentCreatorOnline.service.impl;

import hcmut.contentCreatorOnline.dto.user.AddressUpdateRequest;
import hcmut.contentCreatorOnline.dto.user.UpdateUserDTO;
import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmut.contentCreatorOnline.controller.user.UserCrudController;
import hcmut.contentCreatorOnline.dto.user.RegisterNewUserRequest;
import hcmut.contentCreatorOnline.dto.user.RegisterNewUserResponse;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.User;
import hcmut.contentCreatorOnline.repository.UserRepository;
import hcmut.contentCreatorOnline.service.UserCrudService;
import hcmut.contentCreatorOnline.utils.LoggerUtil;
import hcmut.contentCreatorOnline.utils.PasswordUtil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserCrudServiceImpl implements UserCrudService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerUtil.getLogger(UserCrudController.class);

    @Override
    public RegisterNewUserResponse createNewUser(RegisterNewUserRequest user) throws ApplicationException {

        try {
            User userWithEmail = userRepository.findByEmail(user.getEmail());

            if (userWithEmail != null) {
                logger.error("User with email " + userWithEmail.getEmail() + " is already exist");
                throw new ApplicationException(ErrorConst.RESOURCE_EXIST, "Email is exist");
            }

            logger.info("Start adding user with email " + user.getEmail());

            // hash plain password
            PasswordUtil passwordUtil = new PasswordUtil();
            String hashedPassword = passwordUtil.hashPassword(user.getPassword());

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
            logger.info("Finish adding user with email " + queryResult.getEmail());

            RegisterNewUserResponse userResponse = RegisterNewUserResponse.builder()
                    .email(queryResult.getEmail())
                    .firstName(queryResult.getFirstName())
                    .lastName(queryResult.getLastName())
                    .gender(queryResult.getGender())
                    .isAdmin(queryResult.isAdmin())
                    .nationality(queryResult.getNationality())
                    .birthday(queryResult.getBirthday())
                    .build();

            return userResponse;

        } catch (ApplicationException e) {

            throw e;

        } catch (RuntimeException e) {

            logger.error("Cannot create user with email " + user.getEmail());
            throw new ApplicationException(ErrorConst.UNEXPECTED_ERROR);
        }
    }

    @Override
    public List<User> getAllUser() throws ApplicationException{
        try {
            return userRepository.findAll();
        }
        catch (ApplicationException e){
            throw e;
        }
    }

    @Override
    public Optional<User> getUserById(UUID userId) throws ApplicationException{
        try {
            return userRepository.findById(userId);
        }
        catch (ApplicationException e){
            throw e;
        }
    }

    @Transactional
    public User updateUser(UUID userId, UpdateUserDTO request){
        return userRepository.findById(userId).map(user -> {
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setGender(request.getGender());
            user.setNationality(request.getNationality());
            user.setBirthday(request.getBirthday());
            //user.setEmail(user.getEmail());

            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public String deleteUser(UUID userId){

        userRepository.deleteById(userId);
        return "User deleted successfully";
    }
//    @Transactional
//    public void updateUserAddress(UUID userId, AddressUpdateRequest request){
//        try {
//            userRepository.updateUserAddress(
//                    userId,
//                    request.getStreet(),
//                    request.getCity(),
//                    request.getState(),
//                    request.getPostalCode(),
//                    request.getCountry()
//            );
//        } catch(Exception e){
//            throw new RuntimeException("Failed to update address: " + e.getMessage());
//        }
//    }
}
