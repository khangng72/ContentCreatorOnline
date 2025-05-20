package hcmut.contentCreatorOnline.repository;

import hcmut.contentCreatorOnline.model.UserReportChapter;
import hcmut.contentCreatorOnline.model.UserReportChapterId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserReportChapterRepository extends JpaRepository<UserReportChapter, UserReportChapterId> {
}

