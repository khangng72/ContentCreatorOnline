package hcmut.contentCreatorOnline.dto.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateChapterReportRequest {
    private UUID chapterId;
    private String reason;
}

