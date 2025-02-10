package hcmut.contentCreatorOnline.service.user;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import hcmut.contentCreatorOnline.dto.user.RegisterNewUserRequest;
import hcmut.contentCreatorOnline.dto.user.RegisterNewUserResponse;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.User;
import hcmut.contentCreatorOnline.repository.UserRepository;
import hcmut.contentCreatorOnline.service.impl.UserServiceImpl;
import hcmut.contentCreatorOnline.utils.PasswordUtil;

public class CreateNewUserTests {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordUtil passwordUtil;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    public RegisterNewUserRequest getMockRequest() {
        String email = "newuser@example.com";
        String password = "password";
        String firstName = "John";
        String lastName = "Doe";
        String gender = "Male";
        boolean isAdmin = false;
        String nationality = "USA";
        LocalDate birthday = LocalDate.of(2002, 2, 7);

        RegisterNewUserRequest mockRequest = new RegisterNewUserRequest(
                email,
                password,
                firstName,
                lastName,
                gender,
                isAdmin,
                nationality,
                birthday);

        return mockRequest;
    }

    public String getMockHashedPassword() {
        return "hashed_password";
    }

    @Test
    void testCreateNewUser_Success() throws ApplicationException {
        // Arrange
        User newUser = User.builder()
                .email(getMockRequest().getEmail())
                .password(getMockHashedPassword())
                .firstName("John")
                .lastName("Doe")
                .gender("Male")
                .nationality("USA")
                .build();

        when(userRepository.findByEmail(getMockRequest().getEmail())).thenReturn(null);
        when(passwordUtil.encode(getMockRequest().getPassword())).thenReturn(getMockHashedPassword());
        when(userRepository.save(any(User.class))).thenReturn(newUser);

        // Method Call
        RegisterNewUserResponse response = userService.createNewUser(getMockRequest());

        // Assert
        assertNotNull(response);
        assertEquals(getMockRequest().getEmail(), response.getEmail());
        assertEquals(getMockRequest().getFirstName(), response.getFirstName());
        assertEquals(getMockRequest().getLastName(), response.getLastName());
        verify(userRepository).save(any(User.class));
    }

    @Test
    void testCreateNewUser_EmailExist() throws ApplicationException {

        // Arrange
        User existUser = User.builder()
                .email(getMockRequest().getEmail())
                .password(getMockHashedPassword())
                .firstName("John")
                .lastName("Doe")
                .gender("Male")
                .nationality("USA")
                .build();
        when(userRepository.findByEmail(getMockRequest().getEmail())).thenReturn(existUser);

        // Method call
        ApplicationException thrownException = assertThrows(ApplicationException.class, () -> {
            userService.createNewUser(getMockRequest());
        });

        // Assert
        assertEquals(ErrorConst.RESOURCE_EXIST.getMessage(), thrownException.getMessage());
        assertEquals("Email is exist", thrownException.getAdditionalInfo());
        assertEquals(ErrorConst.RESOURCE_EXIST.getErrorCode(), thrownException.getErrorCode());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void testCreateNewUser_UnexpectedError() throws ApplicationException {
        // Arrange
        when(userRepository.findByEmail(getMockRequest().getEmail())).thenReturn(null);
        when(passwordUtil.encode(getMockRequest().getPassword())).thenReturn(getMockHashedPassword());
        when(userRepository.save(any(User.class))).thenThrow(new RuntimeException("Database error"));

        ApplicationException thrownException = assertThrows(ApplicationException.class, () -> {
            userService.createNewUser(getMockRequest());
        });

        assertEquals(ErrorConst.UNEXPECTED_ERROR.getMessage(), thrownException.getMessage());
        verify(userRepository, times(1)).save(any(User.class));
    }

}
