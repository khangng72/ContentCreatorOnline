package hcmut.contentCreatorOnline.dto.story;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoryResponse {
    private UUID storyId;

    private LocalDate releaseDate;

    private LocalDate createdDate;

    private Boolean releaseStatus;

    private String storyTitle;

    private Boolean saleOnly;

    private Double salePrice;

    private Integer numberOfLikes;

    private Integer numberOfViews;

    private String coverImageUri;

    private String storyDescription;

    private String tags;

    private Double averageRating;

    private UUID userId;

    private String userPost;

    private List<ChapterStoryResponse> chapters;
}