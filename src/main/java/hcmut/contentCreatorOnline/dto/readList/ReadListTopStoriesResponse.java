package hcmut.contentCreatorOnline.dto.readList;

import hcmut.contentCreatorOnline.dto.story.StoryDTO;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ReadListTopStoriesResponse {
    private Integer status;
    private List<StoryDTO> result;
}
