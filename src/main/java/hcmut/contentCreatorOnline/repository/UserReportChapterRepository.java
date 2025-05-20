package hcmut.contentCreatorOnline.repository;

import hcmut.contentCreatorOnline.dto.report.ReportedChapterSummaryDTO;
import hcmut.contentCreatorOnline.model.UserReportChapter;
import hcmut.contentCreatorOnline.model.UserReportChapterId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserReportChapterRepository extends JpaRepository<UserReportChapter, UserReportChapterId> {

    @Query("""
        SELECT new hcmut.contentCreatorOnline.dto.report.ReportedChapterSummaryDTO(
            c.chapterId,
            c.chapterTitle,
            CONCAT(u.firstName, ' ', u.lastName),
            COUNT(urc),
            c.createdTime)
        FROM UserReportChapter urc
        JOIN urc.chapter c
        JOIN c.story s
        JOIN s.userPost u
        WHERE urc.resolve_state = 'unresolved'
        GROUP BY c.chapterId, c.chapterTitle, u.firstName, u.lastName, c.createdTime
        ORDER BY COUNT(urc) DESC, c.chapterTitle ASC
    """
)
    List<ReportedChapterSummaryDTO> findUnresolvedReportedChaptersSummary(Pageable pageable);
}

