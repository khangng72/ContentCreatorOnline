package hcmut.contentCreatorOnline.controller.comment;

import hcmut.contentCreatorOnline.dto.comment.CommentPageResponse;
import hcmut.contentCreatorOnline.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/chapter/{chapterId}")
    public ResponseEntity<CommentPageResponse> getCommentsPagedByChapterId(@PathVariable("chapterId") UUID chapterId,
                                                                           @RequestParam(defaultValue = "0") int page,
                                                                           @RequestParam(defaultValue = "10") int size,
                                                                           @RequestParam(defaultValue = "createdTime") String sortBy,
                                                                           @RequestParam(defaultValue = "desc") String sortDirection) {

        CommentPageResponse result = commentService.getCommentsPagedByChapterId(chapterId, page, size, sortBy, sortDirection);

        return ResponseEntity.ok(result);
    }
}
