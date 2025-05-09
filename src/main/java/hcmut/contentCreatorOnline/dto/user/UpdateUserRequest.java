package hcmut.contentCreatorOnline.dto.user;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateUserRequest {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String gender;
    private String nationality;
    private LocalDate birthday;
    private String introduction;
}
