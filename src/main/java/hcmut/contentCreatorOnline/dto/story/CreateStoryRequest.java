package hcmut.contentCreatorOnline.dto.story;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStoryRequest {

    @NotNull
    private String storyTitle;
    private Boolean saleOnly;
    private Double salePrice;
    private String coverImageUri;
    private String storyDescription;
}
