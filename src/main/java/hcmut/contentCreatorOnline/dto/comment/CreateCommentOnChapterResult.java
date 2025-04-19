package hcmut.contentCreatorOnline.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentOnChapterResult {
    private UUID commentId;
    private LocalDateTime createdTime;
    private String commentContent;
    private Integer numberOfLikes;
    private boolean isPinned;
}
