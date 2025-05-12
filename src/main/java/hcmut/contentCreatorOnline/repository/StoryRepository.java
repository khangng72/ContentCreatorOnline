package hcmut.contentCreatorOnline.repository;

import hcmut.contentCreatorOnline.model.Story;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StoryRepository extends JpaRepository<Story, UUID> {
    List<Story> findTop10ByUserPost_IdOrderByCreatedTimeDesc(UUID userId);

    List<Story> findByUserPost_Id(UUID userId);

    @Query("SELECT s FROM Story s JOIN s.genres g WHERE g.genreId = :genreId AND s.releaseStatus=true ORDER BY s.averageRating DESC, s.numberOfViews DESC")
    Page<Story> findByGenreId(@Param("genreId") Integer genreId, Pageable pageable);

    List<Story> findByUserPost_IdAndReleaseStatusOrderByUpdatedTimeDesc(UUID userId, boolean releaseStatus);

    List<Story> findByUserPost_IdOrderByUpdatedTimeDesc(UUID userPostId);
}
