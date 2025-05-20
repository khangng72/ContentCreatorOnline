package hcmut.contentCreatorOnline.dto.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReportChapterDetailDTO {
    private UUID userId;
    private String Author;
    private String reason;
    private String resolveState;
    private Date resolveDate;
}