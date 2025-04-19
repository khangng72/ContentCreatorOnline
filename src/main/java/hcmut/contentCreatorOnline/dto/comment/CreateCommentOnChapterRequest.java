package hcmut.contentCreatorOnline.dto.comment;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentOnChapterRequest {
    private String comment_content;
}
