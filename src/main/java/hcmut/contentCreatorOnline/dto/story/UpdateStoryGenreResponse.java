package hcmut.contentCreatorOnline.dto.story;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateStoryGenreResponse {
    private Integer status;
    private UpdateStoryGenreResult result;
}
