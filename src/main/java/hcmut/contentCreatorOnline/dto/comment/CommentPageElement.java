package hcmut.contentCreatorOnline.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentPageElement {
    private UUID commentId;
    private String comment_content;
    private LocalDateTime createdTime;
}
