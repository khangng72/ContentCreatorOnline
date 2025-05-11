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
    public ResponseEntity<List<StoryDTO>> getStoriesPostedByUser(@PathVariable UUID user_id) {
        List<StoryDTO> storyResponses = storyService.getStoriesPostedByUser(user_id);
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

    @GetMapping("/genre/{genre_id}")
    public ResponseEntity<GetStoriesByGenreResponse> getStoriesByGenreId(@PathVariable Integer genre_id,
                                                                         @RequestParam(defaultValue = "0") Integer page,
                                                                         @RequestParam(defaultValue = "10") Integer size) {
        List<StoryDTO> storyResponses = storyService.getStoriesByGenreId(genre_id, page, size);
        return ResponseEntity.ok(new GetStoriesByGenreResponse(200, storyResponses));
    }

    @GetMapping("/search")
    public ResponseEntity<SearchStoryResponse> searchStory(
            @RequestParam String searchTitle,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "createdDate") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDirection
    ) {
        List<StoryDTO> result = storyService.fuzzySearchStoriesByQueryString(searchTitle, page, size, sortBy, sortDirection);
        return ResponseEntity.ok(new SearchStoryResponse(HttpStatus.OK.value(), result));
    }

    @GetMapping("/basicInfo/{story_id}")
    public ResponseEntity<StoryDTO> getBasicInfoByStoryId(@PathVariable UUID story_id) {
        StoryDTO response = storyService.getStoryBasicInfoByStoryId(story_id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/currentReading")
    public ResponseEntity<List<CurrentReadDTO>> getCurrentReading() {
        List<CurrentReadDTO> result = storyService.getCurrentReading();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/published-stories")
    public ResponseEntity<List<StoryDTO>> getPublishedStories() {
        List<StoryDTO> result = storyService.getPublishedStories();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/current-user/all-stories")
    public ResponseEntity<List<StoryDTO>> getAllStoriesByCurrentUser() {
        List<StoryDTO> result = storyService.getAllStoriesByCurrentUser();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{story_id}")
    public ResponseEntity<String> deleteStory(@PathVariable UUID story_id) {
        storyService.deleteStory(story_id);
        return ResponseEntity.ok("Story deleted successfully");
    }

    @GetMapping("/published-info/{story_id}")
    public ResponseEntity<PublishedInfo> getPublishedInfo(@PathVariable UUID story_id) {
        System.out.println(story_id);
        PublishedInfo publishedInfo = storyService.getPublishedInfo(story_id);
        return ResponseEntity.ok(publishedInfo);
    }

    @PutMapping("/unpublish/{story_id}")
    public ResponseEntity<String> unpublishStory(@PathVariable UUID story_id) {
        storyService.unpublishStory(story_id);
        return ResponseEntity.ok("Story unpublished successfully");
    }


}