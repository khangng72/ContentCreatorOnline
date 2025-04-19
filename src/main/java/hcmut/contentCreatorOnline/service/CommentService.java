package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.comment.CommentDTO;
import hcmut.contentCreatorOnline.dto.comment.CommentPageResponse;
import hcmut.contentCreatorOnline.dto.comment.CreateCommentOnChapterRequest;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.Chapter;
import hcmut.contentCreatorOnline.model.Comment;
import hcmut.contentCreatorOnline.model.User;
import hcmut.contentCreatorOnline.model.UserPrincipal;
import hcmut.contentCreatorOnline.repository.ChapterRepository;
import hcmut.contentCreatorOnline.repository.CommentRepository;
import hcmut.contentCreatorOnline.repository.UserRepository;
import hcmut.contentCreatorOnline.utils.SecurityUtils;
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
    private final ChapterRepository chapterRepository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, ChapterRepository chapterRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.chapterRepository = chapterRepository;
        this.userRepository = userRepository;
    }

    public CommentPageResponse getCommentsPagedByChapterId(UUID chapterId, int page, int size, String sortBy, String sortDirection) {
        try {
            Sort.Direction sortDirectionEnum = Sort.Direction.fromString(sortDirection);
            Sort sort = Sort.by(sortDirectionEnum, sortBy);
            Pageable pageable = PageRequest.of(page, size, sort);

            Page<Comment> commentPage = commentRepository.findByChapter_ChapterId(pageable, chapterId);
            List<CommentDTO> commentPageElementList = commentPage.getContent().stream()
                    .map(comment -> new CommentDTO(
                            comment.getCommentId(),
                            comment.getCommentContent(),
                            comment.getCreatedTime(),
                            comment.getNumberOfLikes(),
                            comment.getIsPinned(),
                            comment.getChapter().getChapterId(),
                            comment.getUser().getId(),
                            comment.getUser().getFirstName(),
                            comment.getUser().getLastName()
                    ))
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

    public CommentDTO createCommentOnChapter(UUID chapterId, CreateCommentOnChapterRequest commentRequest) {
        try {
            Chapter chapter = chapterRepository.findById(chapterId)
                    .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Chapter not found"));

            UserPrincipal currentUser = SecurityUtils.getCurrentUser();
            UUID userId = currentUser.getId();

            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "User not found"));

            Comment comment = new Comment();
            comment.setCommentContent(commentRequest.getComment_content());
            comment.setChapter(chapter);
            comment.setUser(user);

            Comment queryResult = commentRepository.save(comment);

            return new CommentDTO(
                    queryResult.getCommentId(),
                    queryResult.getCommentContent(),
                    queryResult.getCreatedTime(),
                    queryResult.getNumberOfLikes(),
                    queryResult.getIsPinned(),
                    queryResult.getChapter().getChapterId(),
                    queryResult.getUser().getId(),
                    queryResult.getUser().getFirstName(),
                    queryResult.getUser().getLastName()
            );
        } catch (Exception e) {
            throw new ApplicationException(ErrorConst.INTERNAL_DATA_INSERT_FAIL, "Failed to create comment");
        }
    }


}
