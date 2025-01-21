package hcmut.contentCreatorOnline.dto.user;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class RegisterNewUserRequestTests {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidRequest() {
        RegisterNewUserRequest request = RegisterNewUserRequest.builder()
                .email("test@example.com")
                .password("password123")
                .firstName("John")
                .lastName("Doe")
                .gender("Male")
                .nationality("Vietnamese")
                .birthday(LocalDate.of(2000, 1, 1))
                .build();

        Set<ConstraintViolation<RegisterNewUserRequest>> violations = validator.validate(request);
        assertTrue(violations.isEmpty(), "There should be no validation errors for a valid request");
    }

    @Test
    void testInvalidRequest_EmptyEmail() {
        RegisterNewUserRequest request = RegisterNewUserRequest.builder()
                .email(null)
                .password("password123")
                .firstName("John")
                .lastName("Doe")
                .gender("Male")
                .nationality("Vietnamese")
                .birthday(LocalDate.of(2000, 1, 1))
                .build();

        Set<ConstraintViolation<RegisterNewUserRequest>> violations = validator.validate(request);

        assertEquals(1, violations.size(), "There should be 1 validation error for an empty email");
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("email is null")));
    }

    @Test
    void testInvalidRequest_NullFields() {
        RegisterNewUserRequest request = RegisterNewUserRequest.builder()
                .email(null)
                .password(null)
                .firstName(null)
                .lastName(null)
                .gender(null)
                .nationality(null)
                .birthday(null)
                .build();

        Set<ConstraintViolation<RegisterNewUserRequest>> violations = validator.validate(request);

        assertEquals(7, violations.size(), "There should be 7 validation errors for missing fields");

        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("email is null")));
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("password is null")));
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("firstName is null")));
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("lastName is null")));
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("gender is null")));
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("nationality is null")));
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("birthday is null")));
    }
}
