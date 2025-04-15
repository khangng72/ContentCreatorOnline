package hcmut.contentCreatorOnline.dto.uploadImage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeleteImageResult {
    private UUID imageId;
    private boolean isDeleted;
}
