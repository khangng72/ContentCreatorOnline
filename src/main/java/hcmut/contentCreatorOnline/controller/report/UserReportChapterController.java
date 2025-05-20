package hcmut.contentCreatorOnline.controller.report;

import hcmut.contentCreatorOnline.model.UserReportChapter;
import hcmut.contentCreatorOnline.service.UserReportChapterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-report-chapters")
public class UserReportChapterController {

    private final UserReportChapterService service;

    public UserReportChapterController(UserReportChapterService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserReportChapter> getAllReports() {
        return service.getAllReports();
    }
}
