package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.comment.CommentDTO;
import hcmut.contentCreatorOnline.dto.comment.CommentPageResponse;
import hcmut.contentCreatorOnline.dto.comment.CreateCommentOnChapterRequest;
import hcmut.contentCreatorOnline.dto.comment.ReplyCommentRequest;
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

import java.time.LocalDateTime;
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
                    .map(comment -> CommentDTO.builder()
                            .commentId(comment.getCommentId())
                            .comment_content(comment.getCommentContent())
                            .createdTime(comment.getCreatedTime())
                            .numberOfLikes(comment.getNumberOfLikes())
                            .isPinned(comment.getIsPinned())
                            .chapterId(comment.getChapter().getChapterId())
                            .userId(comment.getUser().getId())
                            .userFirstName(comment.getUser().getFirstName())
                            .userLastName(comment.getUser().getLastName())
                            .userAvatarUrl(comment.getUser().getAvatarUrl())
                            .build())
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

            return CommentDTO.builder()
                    .commentId(queryResult.getCommentId())
                    .comment_content(queryResult.getCommentContent())
                    .createdTime(queryResult.getCreatedTime())
                    .numberOfLikes(queryResult.getNumberOfLikes())
                    .isPinned(queryResult.getIsPinned())
                    .chapterId(queryResult.getChapter().getChapterId())
                    .userId(queryResult.getUser().getId())
                    .userFirstName(queryResult.getUser().getFirstName())
                    .userLastName(queryResult.getUser().getLastName())
                    .userAvatarUrl(queryResult.getUser().getAvatarUrl())
                    .build();
        } catch (Exception e) {
            throw new ApplicationException(ErrorConst.INTERNAL_DATA_INSERT_FAIL, "Failed to create comment");
        }
    }


    public List<CommentDTO> getRepliesByCommentId(UUID commentId) {

        Comment parentComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Comment not found"));

        List<Comment> replies = parentComment.getReplies();
        return replies.stream()
                .sorted((r1, r2) -> r2.getCreatedTime().compareTo(r1.getCreatedTime()))
                .map(reply -> CommentDTO.builder()
                        .commentId(reply.getCommentId())
                        .comment_content(reply.getCommentContent())
                        .createdTime(reply.getCreatedTime())
                        .numberOfLikes(reply.getNumberOfLikes())
                        .isPinned(reply.getIsPinned())
                        .userId(reply.getUser().getId())
                        .userFirstName(reply.getUser().getFirstName())
                        .userLastName(reply.getUser().getLastName())
                        .userAvatarUrl(reply.getUser().getAvatarUrl())
                        .build())
                .toList();
    }

    public CommentDTO replyToComment(UUID commentId, ReplyCommentRequest replyCommentRequest) {
        Comment parentComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Comment not found"));

        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        UUID userId = currentUser.getId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "User not found"));

        Comment comment = Comment.builder()
                .commentContent(replyCommentRequest.getReplyContent())
                .parentComment(parentComment)
                .user(user)
                .createdTime(LocalDateTime.now())
                .build();

        Comment savedComment = commentRepository.save(comment);

        return CommentDTO.builder()
                .commentId(savedComment.getCommentId())
                .comment_content(savedComment.getCommentContent())
                .createdTime(savedComment.getCreatedTime())
                .numberOfLikes(savedComment.getNumberOfLikes())
                .isPinned(savedComment.getIsPinned())
                .userId(savedComment.getUser().getId())
                .userFirstName(savedComment.getUser().getFirstName())
                .userLastName(savedComment.getUser().getLastName())
                .userAvatarUrl(savedComment.getUser().getAvatarUrl())
                .build();
    }
}
