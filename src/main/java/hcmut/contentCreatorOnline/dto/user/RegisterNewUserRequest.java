package hcmut.contentCreatorOnline.dto.user;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RegisterNewUserRequest {

    @NotNull(message = "email is null")
    private String email;

    @NotNull(message = "password is null")
    private String password;

    @NotNull(message = "firstName is null")
    private String firstName;

    @NotNull(message = "lastName is null")
    private String lastName;

    @NotNull(message = "gender is null")
    private String gender;

    @Builder.Default
    private boolean isAdmin = false;

    @NotNull(message = "nationality is null")
    private String nationality;

    @NotNull(message = "birthday is null")
    private LocalDate birthday;
}
