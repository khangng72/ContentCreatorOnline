package hcmut.contentCreatorOnline.controller.uploadImage;

import hcmut.contentCreatorOnline.dto.uploadImage.*;
import hcmut.contentCreatorOnline.service.impl.UploadImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class UploadImageController {
    private final UploadImageService uploadImageService;

    @PostMapping("/upload")
    public ResponseEntity<UploadImageResponse> uploadImage(@RequestBody UploadImageRequest uploadImageRequest) {
        UploadImageResult result = uploadImageService.saveImage(uploadImageRequest.getImageUri());
        return new ResponseEntity<>(new UploadImageResponse(HttpStatus.CREATED.value(), result), HttpStatus.CREATED);
    }

    @DeleteMapping("/{imageId}")
    public ResponseEntity<DeleteImageResponse> deleteImage(@PathVariable UUID imageId) {
        DeleteImageResult result = uploadImageService.deleteImage(imageId);
        return ResponseEntity.ok(new DeleteImageResponse(HttpStatus.OK.value(), result));
    }
}
