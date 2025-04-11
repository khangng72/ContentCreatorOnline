package hcmut.contentCreatorOnline.controller.uploadImage;

import hcmut.contentCreatorOnline.model.UploadImage;
import hcmut.contentCreatorOnline.service.impl.UploadImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class UploadImageController {
    private final UploadImageService uploadImageService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam UUID userId,
                                         @RequestParam String imageUrl) {
        UploadImage savedImage = uploadImageService.saveImage(userId, imageUrl);
        return ResponseEntity.ok(savedImage);
    }

    @DeleteMapping("/{imageId}")
    public ResponseEntity<?> deleteImage(@PathVariable UUID imageId) {
        uploadImageService.deleteImage(imageId);
        return ResponseEntity.ok("Image deleted successfully");
    }
}
