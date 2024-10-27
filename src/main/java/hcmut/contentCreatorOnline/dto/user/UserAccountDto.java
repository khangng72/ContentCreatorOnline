package hcmut.contentCreatorOnline.dto.user;

import java.util.UUID;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAccountDto {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String first_name;
    private String last_name;
    private String gender;
    private String user_password;
    private LocalDate birthday;
    private String nationality;
    private String email;
    private boolean is_admin = false;
    private String address;
}
