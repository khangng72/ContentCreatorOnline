package hcmut.contentCreatorOnline.dto.comment;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetRepliesResponse {
    private Integer status;
    private List<CommentDTO> result;
}
