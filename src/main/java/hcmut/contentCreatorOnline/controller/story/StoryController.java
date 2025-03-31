package hcmut.contentCreatorOnline.controller.story;

import hcmut.contentCreatorOnline.dto.story.CreateStoryRequest;
import hcmut.contentCreatorOnline.dto.story.CreateStoryResponse;
import hcmut.contentCreatorOnline.dto.story.CreateStoryResult;
import hcmut.contentCreatorOnline.service.StoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

