package hcmut.contentCreatorOnline.repository;

import hcmut.contentCreatorOnline.model.UserLikeStory;
import hcmut.contentCreatorOnline.model.UserLikeStoryId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserLikeStoryRepository extends JpaRepository<UserLikeStory, UserLikeStoryId> {
    Optional<UserLikeStory> findByUserIdAndStoryId(UUID userId, UUID storyId);
}
