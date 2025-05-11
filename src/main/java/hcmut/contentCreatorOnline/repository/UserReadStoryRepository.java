package hcmut.contentCreatorOnline.repository;

import hcmut.contentCreatorOnline.model.UserReadStory;
import hcmut.contentCreatorOnline.model.UserReadStoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReadStoryRepository extends JpaRepository<UserReadStory, UserReadStoryId> {
}
