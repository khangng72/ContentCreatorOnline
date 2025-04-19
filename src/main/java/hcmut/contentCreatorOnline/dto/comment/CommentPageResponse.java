package hcmut.contentCreatorOnline.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentPageResponse {
    private Integer status;
    private List<CommentDTO> result;
    private Integer currentPage;
    private Integer totalItems;
    private Integer totalPages;
}
