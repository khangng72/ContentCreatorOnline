package hcmut.contentCreatorOnline.dto.chapter;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChapterListOnlyView {
    private UUID chapterId;
    private String chapterTitle;
    private LocalDateTime chapterCreatedTime;
    private Boolean isPublished;
    private Integer numberOfComment;
    private Integer numberOfLikes;
}
