package hcmut.contentCreatorOnline.dto.story;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetStoriesByGenreResponse {
    private int status;
    private List<StoryDTO> result;
}
