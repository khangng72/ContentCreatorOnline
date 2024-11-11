package hcmut.contentCreatorOnline.dto.user;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserRegisterRequestDto {
    private String first_name;
    private String last_name;
    private String gender;
    private String user_password;
    private LocalDate birthday;
    private String nationality;
    private String email;
    private String address;
}
