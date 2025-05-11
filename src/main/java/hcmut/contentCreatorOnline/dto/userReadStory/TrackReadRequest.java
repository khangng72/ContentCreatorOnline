package hcmut.contentCreatorOnline.dto.userReadStory;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TrackReadRequest {
    private UUID chapterId;
    private UUID storyId;
}
