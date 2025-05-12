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

    @GetMapping("/{chapterId}")
    public ResponseEntity<ChapterDTO> getChapterById(@PathVariable UUID chapterId) {
        ChapterDTO chapter = chapterService.getChapterById(chapterId);
        return ResponseEntity.ok(chapter);
    }

    @GetMapping("/check_if_current_user_liked/{chapterId}")
    public ResponseEntity<Boolean> checkIfCurrentUserLiked(@PathVariable UUID chapterId) {
        boolean isLiked = chapterService.checkIfCurrentUserLiked(chapterId);
        return ResponseEntity.ok(isLiked);
    }

    @PostMapping("/toggle_current_user_like/{chapterId}")
    public ResponseEntity<Boolean> toggleCurrentUserLiked(@PathVariable UUID chapterId) {
        System.out.println("toggleCurrentUserLiked chapterId: " + chapterId);
        boolean isLiked = chapterService.toggleCurrentUserLike(chapterId);
        return ResponseEntity.ok(isLiked);
    }

    @GetMapping("/all-by-story/{storyId}")
    public ResponseEntity<List<ChapterDTO>> getAllChaptersByStoryId(@PathVariable UUID storyId) {
        List<ChapterDTO> chapters = chapterService.getAllChaptersByStoryId(storyId);
        return ResponseEntity.ok(chapters);
    }

    @DeleteMapping("/{chapterId}")
    public ResponseEntity<String> deleteChapter(@PathVariable UUID chapterId) {
        chapterService.deleteChapterById(chapterId);
        return ResponseEntity.ok("Chapter deleted successfully");
    }

    @PutMapping("/update-chapter-title/{chapterId}")
    public ResponseEntity<String> updateChapterTitle(@PathVariable UUID chapterId, @RequestBody UpdateTitleRequest updateTitleRequest) {
        chapterService.updateChapterTitle(chapterId, updateTitleRequest);
        return ResponseEntity.ok("Chapter title updated successfully");
    }

}
