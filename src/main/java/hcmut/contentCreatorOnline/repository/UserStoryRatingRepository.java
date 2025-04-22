package hcmut.contentCreatorOnline.repository;

import hcmut.contentCreatorOnline.model.Story;
import hcmut.contentCreatorOnline.model.UserStoryRating;
import hcmut.contentCreatorOnline.model.UserStoryRatingId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserStoryRatingRepository extends JpaRepository<UserStoryRating, UserStoryRatingId> {
    Optional<UserStoryRating> findById(UserStoryRatingId id);
    List<UserStoryRating> findByStory(Story story); // Dùng để tính điểm trung bình nếu cần
}

