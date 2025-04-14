package hcmut.contentCreatorOnline.service.impl;

import hcmut.contentCreatorOnline.dto.chapter.ChapterRequest;
import hcmut.contentCreatorOnline.dto.chapter.ChapterResponseDTO;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

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

//    public List<ChapterResponseDTO> getAllChaptersNewestFirst() {
//        return chapterRepository.findAllChaptersWithStoryAndUser()
//                .stream()
//                .map(c -> {
//                    Story s = c.getStory();
//                    User u = s.getUserPost();
//                    return new ChapterResponseDTO(
//                            c.getChapterId(),
//                            c.getChapterTitle(),
//                            c.getChapterDescription(),
//                            c.getChapterContent(),
//                            c.getChapterImageUri(),
//                            null, // c.getCreatedAt() nếu có
//                            s.getStoryTitle(),
//                            s.getStoryDescription(),
//                            u.getFirstName(),
//                            u.getLastName(),
//                            u.getEmail()
//                    );
//                }).collect(Collectors.toList());
//    }

    public Map<String, Object> getAllChaptersNewestFirstPaged(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdTime").descending());
        Page<Chapter> chapterPage = chapterRepository.findAllChaptersWithStoryAndUser(pageable);

        List<ChapterResponseDTO> chapterDTOs = chapterPage.getContent().stream().map(c -> {
            Story s = c.getStory();
            User u = s.getUserPost();
            return new ChapterResponseDTO(
                    c.getChapterId(),
                    c.getChapterTitle(),
                    c.getChapterDescription(),
                    c.getChapterContent(),
                    c.getChapterImageUri(),
                    c.getCreatedTime(),
                    s.getStoryTitle(),
                    s.getStoryDescription(),
                    u.getFirstName(),
                    u.getLastName(),
                    u.getEmail()
            );
        }).collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("status", 200);
        response.put("result", chapterDTOs);
        response.put("currentPage", chapterPage.getNumber());
        response.put("totalItems", chapterPage.getTotalElements());
        response.put("totalPages", chapterPage.getTotalPages());

        return response;
    }
}
