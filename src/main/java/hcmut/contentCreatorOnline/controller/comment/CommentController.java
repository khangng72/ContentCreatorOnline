package hcmut.contentCreatorOnline.controller.comment;

import hcmut.contentCreatorOnline.dto.comment.*;
import hcmut.contentCreatorOnline.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping("/chapter/{chapterId}")
    public ResponseEntity<CreateCommentOnChapterResponse> createCommentOnChapter(@PathVariable("chapterId") UUID chapterId,
                                                                                 @RequestBody CreateCommentOnChapterRequest createCommentOnChapterRequest) {

        CommentDTO result = commentService.createCommentOnChapter(chapterId, createCommentOnChapterRequest);
        CreateCommentOnChapterResponse response = new CreateCommentOnChapterResponse(HttpStatus.CREATED.value(), result);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/replies/{commentId}")
    public ResponseEntity<GetRepliesResponse> getRepliesByCommentId(@PathVariable("commentId") UUID commentId) {
        List<CommentDTO> replies = commentService.getRepliesByCommentId(commentId);
        return ResponseEntity.ok(new GetRepliesResponse(HttpStatus.OK.value(), replies));
    }
}
