package hcmut.contentCreatorOnline.dto.story;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SearchStoryResponse {
    private Integer status;
    private List<StoryDTO> result;
}
