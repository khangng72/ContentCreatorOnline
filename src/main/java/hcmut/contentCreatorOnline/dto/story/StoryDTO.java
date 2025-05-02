package hcmut.contentCreatorOnline.dto.story;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class StoryDTO {
    private UUID storyId;
    private String storyTitle;
    private String storyDescription;
    private String coverImageUri;
    private String userPost;
    private Integer numberOfViews;
    private Integer numberOfChapters;
}
