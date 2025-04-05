package hcmut.contentCreatorOnline.controller.chapter;

import hcmut.contentCreatorOnline.dto.chapter.ChapterRequest;
import hcmut.contentCreatorOnline.model.Chapter;
import hcmut.contentCreatorOnline.model.Story;
import hcmut.contentCreatorOnline.repository.ChapterRepository;
import hcmut.contentCreatorOnline.repository.StoryRepository;
import hcmut.contentCreatorOnline.service.impl.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/chapter")
@RequiredArgsConstructor
public class ChapterController {
    private final ChapterService chapterService;

    @PostMapping("/newChapter/{storyId}")
    public ResponseEntity<Map<String, Object>> createNewChapter(
            @PathVariable("storyId") UUID storyId,
            @RequestBody ChapterRequest chapterRequest) {

        Chapter newChapter = chapterService.createNewChapter(storyId, chapterRequest);

        NewChapterResponseDTO responseDTO = new NewChapterResponseDTO(
                newChapter.getChapterId(),
                newChapter.getStory().getStoryId()
        );

        Map<String, Object> response = new HashMap<>();
        response.put("status", 201);
        response.put("result", responseDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
