package hcmut.contentCreatorOnline.controller.userReadStory;

import hcmut.contentCreatorOnline.dto.userReadStory.TrackReadRequest;
import hcmut.contentCreatorOnline.service.UserReadStoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-read-story")
@AllArgsConstructor
public class UserReadStoryController {

    private final UserReadStoryService userReadStoryService;

    @PostMapping
    public ResponseEntity<String> trackReadStory(@RequestBody TrackReadRequest userReadStory) {
        String result = userReadStoryService.trackReadStory(userReadStory);
        return ResponseEntity.ok(result);
    }
}
