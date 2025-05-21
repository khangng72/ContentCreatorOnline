package hcmut.contentCreatorOnline.dto.report;

import lombok.*;

import java.util.Date;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserReportChapterDTO {
    private UUID chapterId;
    private UUID userId;
    private String reason;
    private Date reportDate;
    private String resolveState;
}
