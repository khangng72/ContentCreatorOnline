package hcmut.contentCreatorOnline.repository;

import hcmut.contentCreatorOnline.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ChapterRepository extends JpaRepository<Chapter, UUID> {
    List<Chapter> findByStory_StoryId(UUID storyId);
    @Query("SELECT COALESCE(MAX(c.chapterNumber), 0) FROM Chapter c WHERE c.story.storyId = :storyId")
    int findMaxChapterNumberByStoryId(@Param("storyId") UUID storyId);
}
