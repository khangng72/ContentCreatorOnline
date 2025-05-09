package hcmut.contentCreatorOnline.dto.story;

import hcmut.contentCreatorOnline.dto.genre.GenreResult;
import lombok.*;

import java.util.List;
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
    private UUID userId;
    private Integer numberOfViews;
    private Integer numberOfChapters;
    private Double averageRating;
    private List<GenreResult> genres;
}
