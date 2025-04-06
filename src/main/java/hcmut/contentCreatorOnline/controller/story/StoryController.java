package hcmut.contentCreatorOnline.controller.story;

import hcmut.contentCreatorOnline.dto.genre.GenreListRequest;
import hcmut.contentCreatorOnline.dto.story.*;
import hcmut.contentCreatorOnline.model.Story;
import hcmut.contentCreatorOnline.service.StoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/story")
public class StoryController {

    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

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
    public ResponseEntity<List<StoryDTO>> getStoriesPostByUser(@PathVariable UUID user_id) {
        List<StoryDTO> storiesDTOs = storyService.getStoriesPostedByUser(user_id);
        return ResponseEntity.ok(storiesDTOs);
    }

    @GetMapping("/{story_id}")
    public ResponseEntity<StoryDTO> getStoryByStoryId(@PathVariable UUID story_id){
        StoryDTO storyDTO = storyService.getStoryByStoryId(story_id);
        return ResponseEntity.ok(storyDTO);
    }

    @GetMapping("/own/{user_id}")
    public ResponseEntity<List<StoryDTO>> getStoriesOwnedByUser(@PathVariable UUID user_id) {
        List<StoryDTO> storiesDTOs = storyService.getStoriesOwnedByUser(user_id);
        return ResponseEntity.ok(storiesDTOs);
    }
}

