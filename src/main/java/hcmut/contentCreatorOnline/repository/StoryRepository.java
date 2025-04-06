package hcmut.contentCreatorOnline.repository;

import hcmut.contentCreatorOnline.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StoryRepository extends JpaRepository<Story, UUID> {
    // Tìm tất cả các truyện của tác giả theo user_id (user_post_id)
    List<Story> findByUserPost_Id(UUID userId);
}
