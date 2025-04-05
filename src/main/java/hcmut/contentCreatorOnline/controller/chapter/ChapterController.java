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

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/story")
@RequiredArgsConstructor
public class ChapterController {
    private final ChapterService chapterService;

    @PostMapping("/newChapter/{storyId}")
    public ResponseEntity<?> createChapter(
            @PathVariable UUID storyId,
            @RequestBody ChapterRequest request) {

        Chapter chapter = chapterService.createNewChapter(storyId, request);
        return ResponseEntity.ok("Chapter " + chapter.getChapterNumber() + " created successfully!");
    }

}
