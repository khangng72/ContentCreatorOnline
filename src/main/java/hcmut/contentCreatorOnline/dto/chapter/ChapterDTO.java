package hcmut.contentCreatorOnline.dto.chapter;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChapterDTO {
    private UUID chapterId;
    private String chapterTitle;
    private String chapterDescription;
    private String chapterContent;
    private Integer chapterNumber;
    private String chapterImageUri;
    private LocalDateTime createdTime;
    private Integer numberOfLikes;
    private Integer numberOfComments;
    private UUID nextChapterId;
    private String storyTitle;
}
