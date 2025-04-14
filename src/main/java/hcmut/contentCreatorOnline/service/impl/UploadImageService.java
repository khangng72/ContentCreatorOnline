package hcmut.contentCreatorOnline.service.impl;

import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
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
    private final UserRepository userRepository;

    public UploadImage saveImage(UUID userId, String imageUri) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "User with id " + userId + " not found"));

        UploadImage image = new UploadImage();
        image.setImageUri(imageUri);
        image.setUserUpload(user);
        image.setUploadedDay(LocalDate.now());

        return uploadImageRepository.save(image);
    }

    // This is a soft delete
    public void deleteImage(UUID imageId) {
        UploadImage image = uploadImageRepository.findById(imageId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Image with id " + imageId + " not found"));

        image.setIsDeleted(true);
        uploadImageRepository.save(image);
    }
}

