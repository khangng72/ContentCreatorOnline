package hcmut.contentCreatorOnline.repository;

import hcmut.contentCreatorOnline.model.UploadImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UploadImageRepository extends JpaRepository<UploadImage, UUID> {
    List<UploadImage> findByUserUpload_Id(UUID userId);
}
