package hcmut.contentCreatorOnline.dto.story;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoryDTO {
    private UUID storyId;
    private String storyTitle;
    private String storyDescription;
    private String coverImageUri;
    private LocalDate releaseDate;
}
