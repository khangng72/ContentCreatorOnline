package hcmut.contentCreatorOnline.dto.story;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChapterStoryResponse {
    private UUID chapterId;
    private String chapterTitle;
    private String chapterDescription;
    private String chapterContent;
    private String chapterImageUri;
    private Integer chapterNumber;
}
