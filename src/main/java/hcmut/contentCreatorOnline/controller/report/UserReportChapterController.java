package hcmut.contentCreatorOnline.controller.report;

import hcmut.contentCreatorOnline.dto.report.CreateChapterReportRequest;
import hcmut.contentCreatorOnline.dto.report.ReportedChapterSummaryDTO;
import hcmut.contentCreatorOnline.dto.report.UserReportChapterDetailDTO;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.model.UserReportChapter;
import hcmut.contentCreatorOnline.service.UserReportChapterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/report")
public class UserReportChapterController {

    private final UserReportChapterService userReportChapterService;

    public UserReportChapterController(UserReportChapterService userReportChapterService) {
        this.userReportChapterService = userReportChapterService;
    }

    @GetMapping
    public List<UserReportChapter> getAllReports() {
        return userReportChapterService.getAllReports();
    }

    @PostMapping("/chapters")
    public ResponseEntity<?> createReport(@RequestBody CreateChapterReportRequest request) {
        try {
            String report = userReportChapterService.createReport(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(report);
        } catch (ApplicationException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/chapters/unresolved-summary")
    public ResponseEntity<List<ReportedChapterSummaryDTO>> getUnresolvedChapterReports(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        List<ReportedChapterSummaryDTO> summaries = userReportChapterService.getUnresolvedReportedChapters(page, size);
        return ResponseEntity.ok(summaries);
    }

    @GetMapping("/admin/reported-chapters/{chapterId}")
    public ResponseEntity<List<UserReportChapterDetailDTO>> getReportDetails(
            @PathVariable UUID chapterId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(userReportChapterService.getReportDetailsByChapterId(chapterId, page, size));
    }

    @GetMapping("/current-user/{chapterId}")
    public ResponseEntity<Boolean> checkIfCurrentUserHasReportedChapter(
            @PathVariable UUID chapterId
    ) {
        return ResponseEntity.ok(userReportChapterService.checkIfCurrentUserHasReportedChapter(chapterId));
    }

}
