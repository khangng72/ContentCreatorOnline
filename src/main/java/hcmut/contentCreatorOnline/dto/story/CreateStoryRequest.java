package hcmut.contentCreatorOnline.dto.story;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStoryRequest {

    @NotNull
    private String storyTitle;
    private Boolean saleOnly = false;
    private Double salePrice = null;
    private String coverImageUri = null;
    private String storyDescription = null;
    private LocalDate releaseDate = null;
    private Boolean releaseStatus = false;
}
