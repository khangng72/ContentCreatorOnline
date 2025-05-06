package hcmut.contentCreatorOnline.controller.rating;

import hcmut.contentCreatorOnline.dto.RatingDTO;
import hcmut.contentCreatorOnline.model.UserPrincipal;
import hcmut.contentCreatorOnline.service.UserStoryRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static hcmut.contentCreatorOnline.utils.SecurityUtils.getCurrentUser;

@RestController
@RequestMapping("/rate_story")
@RequiredArgsConstructor
public class UserStoryRatingController {

    private final UserStoryRatingService ratingService;

    @PostMapping
    public ResponseEntity<String> rateStory(@RequestBody RatingDTO ratingDTO) {
        try {
            if (ratingDTO.getUserId() == null) {
                UserPrincipal currentUser = getCurrentUser();
                ratingDTO.setUserId(currentUser.getId());
            }
            ratingService.rateStory(ratingDTO);
            return ResponseEntity.ok("Rating submitted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
