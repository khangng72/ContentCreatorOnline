package hcmut.contentCreatorOnline.dto.uploadImage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteImageResponse {
    private Integer status;
    private DeleteImageResult result;
}
