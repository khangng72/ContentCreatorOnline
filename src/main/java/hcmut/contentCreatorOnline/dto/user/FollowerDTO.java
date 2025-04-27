package hcmut.contentCreatorOnline.dto.user;

import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FollowerDTO {
    private UUID userId;
    private String firstName;
    private String lastName;
}
