package hcmut.contentCreatorOnline.dto.report;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BanChapterDTO {
    UUID userReportId;
    Boolean isBanned;
}
