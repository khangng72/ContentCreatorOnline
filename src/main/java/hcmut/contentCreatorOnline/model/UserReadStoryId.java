package hcmut.contentCreatorOnline.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.UUID;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class UserReadStoryId {
    private UUID userId;
    private UUID storyId;
}
