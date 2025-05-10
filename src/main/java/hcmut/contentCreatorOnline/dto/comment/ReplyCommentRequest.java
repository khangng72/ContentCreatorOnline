package hcmut.contentCreatorOnline.dto.comment;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ReplyCommentRequest {
    private String replyContent;
}
