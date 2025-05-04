package hcmut.contentCreatorOnline.dto.readList;

import hcmut.contentCreatorOnline.dto.story.StoryDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetStoriesByReadListIdResponse {
    private Integer status;
    private List<StoryDTO> result;
}
