package hcmut.contentCreatorOnline.dto.comment;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDTO {
    private UUID commentId;
    private String comment_content;
    private LocalDateTime createdTime;
    private Integer numberOfLikes;
    private Boolean isPinned;

    private UUID chapterId;

    private UUID userId;
    private String userFirstName;
    private String userLastName;
    private String userAvatarUrl;
}
