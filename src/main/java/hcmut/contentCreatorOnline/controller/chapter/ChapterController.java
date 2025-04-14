package hcmut.contentCreatorOnline.controller.chapter;

import hcmut.contentCreatorOnline.dto.chapter.ChapterRequest;
import hcmut.contentCreatorOnline.dto.chapter.ChapterResponseDTO;
import hcmut.contentCreatorOnline.dto.chapter.CreateNewChapterStoryResponse;
import hcmut.contentCreatorOnline.dto.chapter.NewChapterResponseDTO;
import hcmut.contentCreatorOnline.model.Chapter;
import hcmut.contentCreatorOnline.repository.ChapterRepository;
import hcmut.contentCreatorOnline.service.impl.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/chapter")
@RequiredArgsConstructor
public class ChapterController {
    private final ChapterService chapterService;
    private final ChapterRepository chapterRepository;

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

//    @GetMapping("/latest")
//    public ResponseEntity<?> getLatestChapters() {
//        List<ChapterResponseDTO> chapters = chapterService.getAllChaptersNewestFirst();
//        Map<String, Object> response = new HashMap<>();
//        response.put("status", 200);
//        response.put("result", chapters);
//        return ResponseEntity.ok(response);
//    }
    @GetMapping("/latest")
    public ResponseEntity<?> getLatestChaptersPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Map<String, Object> chapters = chapterService.getAllChaptersNewestFirstPaged(page, size);
        return ResponseEntity.ok(chapters);
    }

}
