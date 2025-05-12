package hcmut.contentCreatorOnline.dto.story;

import hcmut.contentCreatorOnline.dto.genre.GenreResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateStoryRequest {
    private UUID storyId;
    private String storyTitle;
    private String storyDescription;
    private String coverImageUri;
    private List<GenreResult> genres;
}
