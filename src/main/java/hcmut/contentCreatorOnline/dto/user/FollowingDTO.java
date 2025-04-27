package hcmut.contentCreatorOnline.dto.user;

import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FollowingDTO {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String avatarUrl;
}
