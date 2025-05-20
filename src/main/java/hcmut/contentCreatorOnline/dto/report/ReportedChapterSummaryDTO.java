package hcmut.contentCreatorOnline.dto.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Builder
public class ReportedChapterSummaryDTO {
    private UUID chapterId;
    private String chapterTitle;
    private String authorFullName;
    private Long reportCount;
    private LocalDateTime createdTime;

    public ReportedChapterSummaryDTO(UUID chapterId, String chapterTitle, String authorFullName, Long reportCount, LocalDateTime createdTime) {
        this.chapterId = chapterId;
        this.chapterTitle = chapterTitle;
        this.authorFullName = authorFullName;
        this.reportCount = reportCount;
        this.createdTime = createdTime;
    }
}
