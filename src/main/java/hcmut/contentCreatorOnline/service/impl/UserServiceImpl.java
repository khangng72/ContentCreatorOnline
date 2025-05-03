package hcmut.contentCreatorOnline.service.impl;

import hcmut.contentCreatorOnline.dto.user.*;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.Genre;
import hcmut.contentCreatorOnline.model.User;
import hcmut.contentCreatorOnline.model.UserPrincipal;
import hcmut.contentCreatorOnline.repository.GenreRepository;
import hcmut.contentCreatorOnline.repository.UserRepository;
import hcmut.contentCreatorOnline.service.JwtService;
import hcmut.contentCreatorOnline.service.UserService;
import hcmut.contentCreatorOnline.utils.LoggerUtil;
import hcmut.contentCreatorOnline.utils.PasswordUtil;
import hcmut.contentCreatorOnline.utils.SecurityUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerUtil.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordUtil passwordUtil;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final GenreRepository genreRepository;

    @Value("${spring.application.fuzzy-search.threshold}")
    private double threshold;

    public UserServiceImpl(UserRepository userRepository, PasswordUtil passwordUtil, JwtService jwtService,
                           AuthenticationManager authenticationManager, GenreRepository genreRepository) {
        this.userRepository = userRepository;
        this.passwordUtil = passwordUtil;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.genreRepository = genreRepository;
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

            Set<Genre> genres = new HashSet<>();
            if (user.getGenreIds() != null && !user.getGenreIds().isEmpty()) {
                genres = new HashSet<>(genreRepository.findAllById(user.getGenreIds()));
                if (genres.size() != user.getGenreIds().size()) {
                    throw new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "One or more genres not found");
                }
            }

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
                    .genreSet(genres)
                    .build();

            // Gán genreSet cho user
            newUser.setGenreSet(genres);

            // Gán user ngược lại cho từng genre
            for (Genre genre : genres) {
                genre.getUsers().add(newUser);
            }

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

    @Override
    public UserResponseDTO getCurrentUser() {
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        UUID userId = currentUser.getId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Integer numberOfStories = user.getStoryPost().size();
        Integer numberOfFollowers = user.getFollowers().size();
        Integer numberOfFollowing = user.getFollowing().size();

        return UserResponseDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .gender(user.getGender())
                .isAdmin(user.isAdmin())
                .isActive(user.isActive())
                .nationality(user.getNationality())
                .birthday(user.getBirthday())
                .avatarUrl(user.getAvatarUrl())
                .backgroundUrl(user.getBackgroundUrl())
                .introduction(user.getIntroduction())
                .numberOfFollowers(numberOfFollowers)
                .numberOfStories(numberOfStories)
                .numberOfFollowing(numberOfFollowing)
                .build();
    }

    @Override
    public List<FollowerDTO> getFollowersByUserId(UUID userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<FollowerDTO> result = userRepository.findFollowersById(userId, pageable);
        return result.getContent();
    }

    @Override
    public List<FollowingDTO> getFollowingByUserId(UUID userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<FollowingDTO> result = userRepository.findFollowingById(userId, pageable);
        return result.getContent();
    }

    @Override
    public List<UserResponseDTO> searchUserByKeyword(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> result = userRepository.searchUserByKeyword(keyword, pageable, threshold);
        return result.getContent().stream().map(
                user -> UserResponseDTO.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .gender(user.getGender())
                        .isAdmin(user.isAdmin())
                        .isActive(user.isActive())
                        .nationality(user.getNationality())
                        .birthday(user.getBirthday())
                        .avatarUrl(user.getAvatarUrl())
                        .backgroundUrl(user.getBackgroundUrl())
                        .introduction(user.getIntroduction())
                        .numberOfStories(user.getStoryPost().size())
                        .numberOfFollowers(user.getFollowers().size())
                        .numberOfFollowing(user.getFollowing().size()).build()

        ).toList();
    }

}
