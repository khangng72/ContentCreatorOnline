package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.report.CreateChapterReportRequest;
import hcmut.contentCreatorOnline.dto.report.ReportedChapterSummaryDTO;
import hcmut.contentCreatorOnline.dto.report.UserReportChapterDetailDTO;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.*;
import hcmut.contentCreatorOnline.repository.ChapterRepository;
import hcmut.contentCreatorOnline.repository.UserReportChapterRepository;
import hcmut.contentCreatorOnline.repository.UserRepository;
import hcmut.contentCreatorOnline.utils.SecurityUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserReportChapterService {

    private final UserReportChapterRepository userReportChapterRepository;
    private final ChapterRepository chapterRepository;
    private final UserRepository userRepository;

    public UserReportChapterService(UserReportChapterRepository repository, ChapterRepository chapterRepository, UserRepository userRepository) {
        this.userReportChapterRepository = repository;
        this.chapterRepository = chapterRepository;
        this.userRepository = userRepository;
    }

    public List<UserReportChapter> getAllReports() {
        return userReportChapterRepository.findAll();
    }

    public String createReport(CreateChapterReportRequest request) {
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();

        Chapter chapter = chapterRepository.findById(request.getChapterId())
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Chapter not found"));

        User user = userRepository.findById(currentUser.getId())
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "User not found"));

        UserReportChapterId reportId = new UserReportChapterId(currentUser.getId(), chapter.getChapterId());

        // Kiểm tra nếu đã report rồi thì không cho report lại (nếu muốn)
        if (userReportChapterRepository.existsById(reportId)) {
            throw new IllegalStateException("This user has already reported this chapter.");
        }

        UserReportChapter report = new UserReportChapter();
        report.setId(reportId);
        report.setUser(user);
        report.setChapter(chapter);
        report.setReason(request.getReason());
        report.setResolve_state("unresolved");
        report.setResolveDate(null);
        report.setReportDate(new Date());

        userReportChapterRepository.save(report);
        return "Created report successfully!";
    }

    public List<ReportedChapterSummaryDTO> getUnresolvedReportedChapters(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userReportChapterRepository.findUnresolvedReportedChaptersSummary(pageable);
    }

    public List<UserReportChapterDetailDTO> getReportDetailsByChapterId(UUID chapterId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userReportChapterRepository.findReportDetailsByChapterId(chapterId, pageable);
    }

}
