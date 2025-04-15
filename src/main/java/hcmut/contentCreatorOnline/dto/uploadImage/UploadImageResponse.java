package hcmut.contentCreatorOnline.dto.uploadImage;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UploadImageResponse {
    private Integer status;
    private UploadImageResult result;
}
