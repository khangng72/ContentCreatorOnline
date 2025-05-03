package hcmut.contentCreatorOnline.controller.chapter;

import hcmut.contentCreatorOnline.dto.chapter.*;
import hcmut.contentCreatorOnline.model.Chapter;
import hcmut.contentCreatorOnline.service.impl.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/latest")
    public ResponseEntity<GetChaptersPagedResponse> getChaptersPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdTime") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDirection
    ) {
        GetChaptersPagedResponse result = chapterService.getChaptersPaged(page, size, sortBy, sortDirection);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{chapterId}/likes")
    public ResponseEntity<Integer> getNumberOfLikes(@PathVariable UUID chapterId) {
        int numberOfLikes = chapterService.getNumberOfLikes(chapterId);
        return ResponseEntity.ok(numberOfLikes);
    }

    @GetMapping("/story/{storyId}")
    public ResponseEntity<GetBasicChaptersInfoResponse> getBasicChaptersInfoByStoryId(@PathVariable UUID storyId) {
        List<BasicChapterInfoDTO> basicChaptersInfo = chapterService.getBasicChaptersInfoByStoryId(storyId);
        return ResponseEntity.ok(new GetBasicChaptersInfoResponse(HttpStatus.OK.value(), basicChaptersInfo));
    }

}
