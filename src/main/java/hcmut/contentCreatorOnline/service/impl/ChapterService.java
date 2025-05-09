package hcmut.contentCreatorOnline.service.impl;

import hcmut.contentCreatorOnline.dto.chapter.*;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.Chapter;
import hcmut.contentCreatorOnline.model.Story;
import hcmut.contentCreatorOnline.model.User;
import hcmut.contentCreatorOnline.repository.ChapterRepository;
import hcmut.contentCreatorOnline.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChapterService {

    private final StoryRepository storyRepository;
    private final ChapterRepository chapterRepository;

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
                .map(chapter -> new BasicChapterInfoDTO(
                        chapter.getChapterId(),
                        chapter.getChapterTitle(),
                        chapter.getChapterDescription(),
                        chapter.getChapterNumber(),
                        chapter.getCreatedTime()))
                .toList();
    }
}
