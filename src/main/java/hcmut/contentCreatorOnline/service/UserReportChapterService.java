package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.model.UserReportChapter;
import hcmut.contentCreatorOnline.repository.UserReportChapterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReportChapterService {

    private final UserReportChapterRepository repository;

    public UserReportChapterService(UserReportChapterRepository repository) {
        this.repository = repository;
    }

    public List<UserReportChapter> getAllReports() {
        return repository.findAll();
    }
}
