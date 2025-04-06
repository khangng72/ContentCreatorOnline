package hcmut.contentCreatorOnline.controller.chapter;

import hcmut.contentCreatorOnline.dto.chapter.ChapterRequest;
import hcmut.contentCreatorOnline.dto.chapter.CreateNewChapterStoryResponse;
import hcmut.contentCreatorOnline.dto.chapter.NewChapterResponseDTO;
import hcmut.contentCreatorOnline.model.Chapter;
import hcmut.contentCreatorOnline.service.impl.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/chapter")
@RequiredArgsConstructor
public class ChapterController {
    private final ChapterService chapterService;

    @PostMapping("/new/{storyId}")
    public ResponseEntity<CreateNewChapterStoryResponse> createNewChapterStory(
            @PathVariable("storyId") UUID storyId,
            @RequestBody ChapterRequest chapterRequest) {

        Chapter newChapter = chapterService.createNewChapter(storyId, chapterRequest);

        NewChapterResponseDTO responseDTO = new NewChapterResponseDTO(
                newChapter.getChapterId(),
                newChapter.getStory().getStoryId());

        CreateNewChapterStoryResponse response = new CreateNewChapterStoryResponse(HttpStatus.CREATED.value(), responseDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
