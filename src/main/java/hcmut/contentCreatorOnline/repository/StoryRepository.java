package hcmut.contentCreatorOnline.repository;

import hcmut.contentCreatorOnline.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StoryRepository extends JpaRepository<Story, UUID> {
    List<Story> findByUserPost_Id(UUID userId);
    @Query("SELECT s FROM Story s JOIN s.userOwn u WHERE u.id = :userId")
    List<Story> findByUserOwn_Id(@Param("userId") UUID userId);
}
