package hcmut.contentCreatorOnline.dto.user;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterNewUserResponse {
    private String email;

    private String firstName;

    private String lastName;

    private String gender;

    private boolean isAdmin;

    private String nationality;

    private LocalDate birthday;
}
