package hcmut.contentCreatorOnline.service.impl;

import hcmut.contentCreatorOnline.model.UploadImage;
import hcmut.contentCreatorOnline.model.User;
import hcmut.contentCreatorOnline.repository.UploadImageRepository;
import hcmut.contentCreatorOnline.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UploadImageService {
    private final UploadImageRepository uploadImageRepository;
    private final UserRepository userRepository; // giả sử bạn đã có repo này

    public UploadImage saveImage(UUID userId, String imageUrl) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UploadImage image = new UploadImage();
        image.setImageUrl(imageUrl);
        image.setUserUpload(user);
        image.setStatus(true);
        image.setCreatedDay(LocalDate.now());
        image.setUpdatedDay(LocalDate.now());

        return uploadImageRepository.save(image);
    }

    public void deleteImage(UUID imageId) {
        UploadImage image = uploadImageRepository.findById(imageId)
                .orElseThrow(() -> new RuntimeException("Image not found"));
        uploadImageRepository.delete(image);
    }
}

