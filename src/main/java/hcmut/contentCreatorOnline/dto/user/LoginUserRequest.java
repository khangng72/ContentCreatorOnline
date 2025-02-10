package hcmut.contentCreatorOnline.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserRequest {
    @NotNull(message = "email is null")
    private String email;

    @NotNull(message = "password is null")
    private String password;
}
