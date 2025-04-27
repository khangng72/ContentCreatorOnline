package hcmut.contentCreatorOnline.repository;

import hcmut.contentCreatorOnline.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StoryRepository extends JpaRepository<Story, UUID> {
    List<Story> findTop10ByUserPost_IdOrderByCreatedTimeDesc(UUID userId);

    List<Story> findByUserPost_Id(UUID userId);
}
