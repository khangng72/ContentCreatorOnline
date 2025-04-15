package hcmut.contentCreatorOnline.dto.uploadImage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadImageResult {
    private UUID imageId;
    private String imageUri;
}
