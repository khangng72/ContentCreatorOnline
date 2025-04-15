package hcmut.contentCreatorOnline.service.impl;

import hcmut.contentCreatorOnline.dto.uploadImage.DeleteImageResult;
import hcmut.contentCreatorOnline.dto.uploadImage.UploadImageResult;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.UploadImage;
import hcmut.contentCreatorOnline.model.User;
import hcmut.contentCreatorOnline.model.UserPrincipal;
import hcmut.contentCreatorOnline.repository.UploadImageRepository;
import hcmut.contentCreatorOnline.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UploadImageService {
    private final UploadImageRepository uploadImageRepository;

    public UploadImageResult saveImage(String imageUri) {

        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        UUID userId = currentUser.getId();

        User uploader = new User();
        uploader.setId(userId);

        UploadImage image = new UploadImage();
        image.setImageUri(imageUri);
        image.setUserUpload(uploader);
        image.setUploadedDay(LocalDate.now());

        UploadImage savedImage = uploadImageRepository.save(image);

        return new UploadImageResult(savedImage.getImageId(), savedImage.getImageUri());
    }

    // This is a soft delete
    public DeleteImageResult deleteImage(UUID imageId) {
        UploadImage image = uploadImageRepository.findById(imageId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Image with id " + imageId + " not found"));

        image.setIsDeleted(true);

        UploadImage result = uploadImageRepository.save(image);

        return new DeleteImageResult(result.getImageId(), result.getIsDeleted());
    }
}

