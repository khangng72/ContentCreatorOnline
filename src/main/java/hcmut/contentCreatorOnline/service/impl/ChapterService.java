package hcmut.contentCreatorOnline.service.impl;

import hcmut.contentCreatorOnline.dto.chapter.*;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.Chapter;
import hcmut.contentCreatorOnline.model.Story;
import hcmut.contentCreatorOnline.model.User;
import hcmut.contentCreatorOnline.model.UserPrincipal;
import hcmut.contentCreatorOnline.repository.ChapterRepository;
import hcmut.contentCreatorOnline.repository.StoryRepository;
import hcmut.contentCreatorOnline.repository.UserRepository;
import hcmut.contentCreatorOnline.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChapterService {

    private final StoryRepository storyRepository;
    private final ChapterRepository chapterRepository;
    private final UserRepository userRepository;

    // Model to DTO by using mapper
    // ChapterListOnlyView
    private ChapterListOnlyView toChapterListOnlyView(Chapter chapter) {
        return ChapterListOnlyView.builder()
                .chapterId(chapter.getChapterId())
                .chapterTitle(chapter.getChapterTitle())
                .chapterCreatedTime(chapter.getCreatedTime())
                .isPublished(chapter.getIsPublished())
                .numberOfComment(chapter.getNumberOfComment())
                .numberOfLikes(chapter.getNumberOfLikes())
                .build();
    }

    public Chapter createNewChapter(UUID storyId, ChapterRequest request) {
        Story story = storyRepository.findById(storyId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Story not found"));

        // Có thể tối ưu bằng cách viết query lấy max chapterNumber
        int maxChapterNumber = chapterRepository.findMaxChapterNumberByStoryId(storyId);
        int newChapterNumber = maxChapterNumber + 1;

        Chapter chapter = new Chapter();
        chapter.setChapterNumber(newChapterNumber);
        chapter.setChapterTitle(request.getChapterTitle());
        chapter.setChapterDescription(request.getChapterDescription());
        chapter.setChapterContent(request.getChapterContent());
        chapter.setChapterImageUri(request.getChapterImageUri());
        chapter.setStory(story);

        return chapterRepository.save(chapter);
    }

    public GetChaptersPagedResponse getChaptersPaged(int page, int size, String sortBy, String sortDirection) {
        Sort.Direction sortDirectionEnum = Sort.Direction.fromString(sortDirection);
        Sort sort = Sort.by(sortDirectionEnum, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Chapter> chapterPage = chapterRepository.findAllChaptersWithStoryAndUser(pageable);

        List<ChapterPageElement> chapterList = chapterPage.getContent().stream().map(c -> {
            Story s = c.getStory();
            User u = s.getUserPost();
            return new ChapterPageElement(
                    c.getChapterId(),
                    c.getChapterTitle(),
                    c.getChapterDescription(),
                    c.getChapterContent(),
                    c.getChapterImageUri(),
                    c.getChapterNumber(),
                    c.getCreatedTime(),
                    s.getStoryTitle(),
                    s.getStoryDescription(),
                    s.getStoryId(),
                    u.getId(),
                    u.getFirstName(),
                    u.getLastName(),
                    u.getEmail(),
                    u.getAvatarUrl(),
                    c.getNumberOfComment()
            );
        }).collect(Collectors.toList());


        return new GetChaptersPagedResponse(
                200,
                chapterList,
                chapterPage.getNumber(),
                (int) chapterPage.getTotalElements(),
                chapterPage.getTotalPages()
        );
    }

    public int getNumberOfLikes(UUID chapterId) {
        return chapterRepository.countLikesByChapterId(chapterId);
    }

    public List<ChapterListOnlyView> getChaptersByStoryId(UUID storyId) {
        List<Chapter> chapters = chapterRepository.findByStoryId(storyId);
        return chapters.stream()
                .map(this::toChapterListOnlyView)
                .collect(Collectors.toList());
    }

    public List<BasicChapterInfoDTO> getBasicChaptersInfoByStoryId(UUID storyId) {
        List<Chapter> chapters = chapterRepository.findByStoryId(storyId);

        return chapters.stream()
                .filter(Chapter::getIsPublished)
                .sorted(Comparator.comparing(Chapter::getChapterNumber))
                .map(chapter -> new BasicChapterInfoDTO(
                        chapter.getChapterId(),
                        chapter.getChapterTitle(),
                        chapter.getChapterDescription(),
                        chapter.getChapterNumber(),
                        chapter.getCreatedTime()))
                .toList();

    }

    public ChapterDTO getChapterById(UUID chapterId) {
        Chapter targetChapter = chapterRepository.findById(chapterId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Chapter not found"));

        List<UUID> chapterIdLeft = targetChapter
                .getStory()
                .getChapters()
                .stream()
                .filter(chapter -> chapter.getChapterNumber() > targetChapter.getChapterNumber())
                .map(Chapter::getChapterId)
                .toList();

        UUID nextChapterId = !chapterIdLeft.isEmpty() ? chapterIdLeft.get(0) : null;


        return ChapterDTO.builder()
                .chapterId(targetChapter.getChapterId())
                .chapterTitle(targetChapter.getChapterTitle())
                .chapterDescription(targetChapter.getChapterDescription())
                .chapterContent(targetChapter.getChapterContent())
                .chapterNumber(targetChapter.getChapterNumber())
                .createdTime(targetChapter.getCreatedTime())
                .nextChapterId(nextChapterId)
                .numberOfLikes(targetChapter.getUsersLikeChapter().size())
                .numberOfComments(targetChapter.getComments().size())
                .storyTitle(targetChapter.getStory().getStoryTitle())
                .storyId(targetChapter.getStory().getStoryId())
                .chapterImageUri(targetChapter.getChapterImageUri())
                .build();
    }

    public boolean checkIfCurrentUserLiked(UUID chapterId) {
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        Chapter chapter = chapterRepository.findById(chapterId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Chapter not found"));

        return chapter.getUsersLikeChapter().stream()
                .anyMatch(user -> user.getId().equals(currentUser.getId()));
    }

    public boolean toggleCurrentUserLike(UUID chapterId) {
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        Chapter chapter = chapterRepository.findById(chapterId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Chapter not found"));
        User user = userRepository.findById(currentUser.getId())
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "User not found"));

        if (chapter.getUsersLikeChapter().contains(user)) {
            chapter.getUsersLikeChapter().remove(user);
            chapter.setNumberOfLikes(chapter.getNumberOfLikes() - 1);
            chapterRepository.save(chapter);
            return false; // User unliked the chapter
        } else {
            chapter.getUsersLikeChapter().add(user);
            chapter.setNumberOfLikes(chapter.getNumberOfLikes() + 1);
            chapterRepository.save(chapter);
            return true; // User liked the chapter
        }
    }

    public List<ChapterDTO> getAllChaptersByStoryId(UUID storyId) {
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();

        Story story = storyRepository.findById(storyId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Story not found"));

        System.out.println("user_id " + currentUser.getId());
        System.out.println("user_id " + story.getUserPost().getId());
        if (!story.getUserPost().getId().equals(currentUser.getId())) {
            throw new ApplicationException(ErrorConst.FORBIDDEN, "You are not the author of this story");
        }

        return story.getChapters().stream()
                .map(chapter -> ChapterDTO.builder()
                        .chapterId(chapter.getChapterId())
                        .chapterTitle(chapter.getChapterTitle())
                        .chapterDescription(chapter.getChapterDescription())
                        .chapterContent(chapter.getChapterContent())
                        .chapterNumber(chapter.getChapterNumber())
                        .createdTime(chapter.getCreatedTime())
                        .updatedTime(chapter.getUpdatedTime())
                        .nextChapterId(null) // Set to null or handle as needed
                        .numberOfLikes(chapter.getUsersLikeChapter().size())
                        .numberOfComments(chapter.getComments().size())
                        .storyTitle(story.getStoryTitle())
                        .storyId(story.getStoryId())
                        .chapterImageUri(chapter.getChapterImageUri())
                        .isPublished(chapter.getIsPublished())
                        .build())
                .collect(Collectors.toList());
    }


    public void deleteChapterById(UUID chapterId) {
        Chapter chapter = chapterRepository.findById(chapterId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Chapter not found"));

        chapterRepository.delete(chapter);
    }
}
