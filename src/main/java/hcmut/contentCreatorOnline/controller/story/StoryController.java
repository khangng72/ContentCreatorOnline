package hcmut.contentCreatorOnline.controller.story;

import hcmut.contentCreatorOnline.dto.chapter.ChapterListOnlyView;
import hcmut.contentCreatorOnline.dto.genre.GenreListRequest;
import hcmut.contentCreatorOnline.dto.story.*;
import hcmut.contentCreatorOnline.service.StoryService;
import hcmut.contentCreatorOnline.service.impl.ChapterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/story")
@RequiredArgsConstructor
public class StoryController {

    private final StoryService storyService;

    private final ChapterService chapterService;

    @PostMapping
    public ResponseEntity<CreateStoryResponse> createStory(@RequestBody @Valid CreateStoryRequest createStoryRequest) {

        CreateStoryResult result = storyService.createNewStory(createStoryRequest);
        CreateStoryResponse createStoryResponse = new CreateStoryResponse(HttpStatus.CREATED.value(), result);

        return new ResponseEntity<>(createStoryResponse, HttpStatus.CREATED);
    }

    @PutMapping("/updateGenre/{story_id}")
    public ResponseEntity<UpdateStoryGenreResponse> updateStoryGenres(@PathVariable("story_id") UUID storyId,
                                                                      @RequestBody GenreListRequest genreListRequest) {
        UpdateStoryGenreResult result = storyService.updateStoryGenres(storyId, genreListRequest.getGenreList());

        return new ResponseEntity<>(new UpdateStoryGenreResponse(HttpStatus.OK.value(), result), HttpStatus.OK);

    }

    @GetMapping("/post/{user_id}")
    public ResponseEntity<List<StoryResponse>> getStoriesPostedByUser(@PathVariable UUID user_id) {
        List<StoryResponse> storyResponses = storyService.getStoriesPostedByUser(user_id);
        return ResponseEntity.ok(storyResponses);
    }

    @GetMapping("/post/latest/{user_id}")
    public ResponseEntity<List<StoryResponse>> getLatestStoriesPostedByUser(@PathVariable UUID user_id) {
        List<StoryResponse> storyResponses = storyService.getLatestStoriesPostedByUser(user_id);
        return ResponseEntity.ok(storyResponses);
    }


    @GetMapping("/{story_id}")
    public ResponseEntity<StoryResponse> getStoryByStoryId(@PathVariable UUID story_id) {
        StoryResponse storyDTO = storyService.getStoryByStoryId(story_id);
        return ResponseEntity.ok(storyDTO);
    }

    @GetMapping("/{story_id}/chapters")
    public ResponseEntity<List<ChapterListOnlyView>> getChaptersByStoryId(@PathVariable UUID story_id) {
        List<ChapterListOnlyView> chapters = chapterService.getChaptersByStoryId(story_id);
        return ResponseEntity.ok(chapters);
    }
}