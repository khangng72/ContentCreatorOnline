package hcmut.contentCreatorOnline.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequestDto {
    private String email;
    private String password;
}
