package hcmut.contentCreatorOnline.dto.chapter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BasicChapterInfoDTO {
    private UUID chapterId;
    private String chapterTitle;
    private String chapterDescription;
    private Integer chapterNumber;
    private LocalDateTime createdTime;

}
