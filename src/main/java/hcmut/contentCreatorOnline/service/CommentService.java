package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.comment.CommentPageElement;
import hcmut.contentCreatorOnline.dto.comment.CommentPageResponse;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.Comment;
import hcmut.contentCreatorOnline.repository.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentPageResponse getCommentsPagedByChapterId(UUID chapterId, int page, int size, String sortBy, String sortDirection) {
        try {
            Sort.Direction sortDirectionEnum = Sort.Direction.fromString(sortDirection);
            Sort sort = Sort.by(sortDirectionEnum, sortBy);
            Pageable pageable = PageRequest.of(page, size, sort);

            Page<Comment> commentPage = commentRepository.findByChapter_ChapterId(pageable, chapterId);
            List<CommentPageElement> commentPageElementList = commentPage.getContent().stream()
                    .map(comment -> new CommentPageElement(
                            comment.getCommentId(),
                            comment.getCommentContent(),
                            comment.getCreatedTime()))
                    .toList();

            return new CommentPageResponse(
                    200,
                    commentPageElementList,
                    commentPage.getNumber(),
                    (int) commentPage.getTotalElements(),
                    commentPage.getTotalPages()
            );
        } catch (Exception ignored) {
            throw new ApplicationException(ErrorConst.INTERNAL_DATA_SELECT_FAIL, "Failed to get comments");
        }
    }
}
