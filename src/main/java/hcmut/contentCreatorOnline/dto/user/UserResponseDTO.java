package hcmut.contentCreatorOnline.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    private UUID id;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private boolean isAdmin;
    private boolean isActive;
    private String nationality;
    private LocalDate birthday;
    private String avatarUrl;
    private String backgroundUrl;
    private String introduction;
}