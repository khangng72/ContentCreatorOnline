package hcmut.contentCreatorOnline.dto.story;

import hcmut.contentCreatorOnline.dto.genre.GenreResult;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CurrentReadDTO {
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
    private UUID currentChapterId;
}
