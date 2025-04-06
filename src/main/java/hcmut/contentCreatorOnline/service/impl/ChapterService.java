package hcmut.contentCreatorOnline.service.impl;

import hcmut.contentCreatorOnline.dto.chapter.ChapterRequest;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.Chapter;
import hcmut.contentCreatorOnline.model.Story;
import hcmut.contentCreatorOnline.repository.ChapterRepository;
import hcmut.contentCreatorOnline.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChapterService {

    private final StoryRepository storyRepository;
    private final ChapterRepository chapterRepository;

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
}
