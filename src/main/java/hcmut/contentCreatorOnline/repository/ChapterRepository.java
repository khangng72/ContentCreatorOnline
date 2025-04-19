package hcmut.contentCreatorOnline.repository;

import hcmut.contentCreatorOnline.model.Chapter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ChapterRepository extends JpaRepository<Chapter, UUID> {

    @Query("SELECT COALESCE(MAX(c.chapterNumber), 0) FROM Chapter c WHERE c.story.storyId = :storyId")
    int findMaxChapterNumberByStoryId(@Param("storyId") UUID storyId);


    @Query("SELECT c FROM Chapter c JOIN c.story s WHERE c.isPublished = true AND s.saleOnly = false")
    Page<Chapter> findAllChaptersWithStoryAndUser(Pageable pageable);

    @Query("SELECT SIZE(c.userChapter) FROM Chapter c WHERE c.chapterId = :chapterId")
    int countLikesByChapterId(@Param("chapterId") UUID chapterId);
}
