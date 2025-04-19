package hcmut.contentCreatorOnline.dto.chapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterPageElement {
    private UUID chapterId;
    private String chapterTitle;
    private String chapterDescription;
    private String chapterContent;
    private String chapterImageUri;
    private Integer chapterNumber;
    private LocalDateTime chapterCreatedTime; // nếu có field created date

    private String storyTitle;
    private String storyDescription;

    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userAvatarUrl;

    private Integer numberOfComment;
}
