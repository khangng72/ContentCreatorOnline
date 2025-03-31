package hcmut.contentCreatorOnline.dto.story;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStoryResponse {
    private int status;
    private CreateStoryResult result;
}
