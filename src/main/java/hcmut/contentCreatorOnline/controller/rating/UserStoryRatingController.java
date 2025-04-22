package hcmut.contentCreatorOnline.controller.rating;

import hcmut.contentCreatorOnline.dto.RatingDTO;
import hcmut.contentCreatorOnline.service.UserStoryRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ratings")
@RequiredArgsConstructor
public class UserStoryRatingController {

    private final UserStoryRatingService ratingService;

    @PostMapping
    public ResponseEntity<String> rateStory(@RequestBody RatingDTO ratingDTO) {
        try {
            ratingService.rateStory(ratingDTO);
            return ResponseEntity.ok("Rating submitted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
