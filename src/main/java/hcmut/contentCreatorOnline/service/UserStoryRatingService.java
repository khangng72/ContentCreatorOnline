package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.userStoryRating.RatingDTO;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.Story;
import hcmut.contentCreatorOnline.model.User;
import hcmut.contentCreatorOnline.model.UserStoryRating;
import hcmut.contentCreatorOnline.model.UserStoryRatingId;
import hcmut.contentCreatorOnline.repository.StoryRepository;
import hcmut.contentCreatorOnline.repository.UserRepository;
import hcmut.contentCreatorOnline.repository.UserStoryRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserStoryRatingService {

    private final UserRepository userRepository;
    private final StoryRepository storyRepository;
    private final UserStoryRatingRepository ratingRepository;

    public void rateStory(RatingDTO ratingDTO) {
        UUID userId = ratingDTO.getUserId();
        UUID storyId = ratingDTO.getStoryId();
        Double ratingValue = ratingDTO.getRating();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND,
                        "User not found"));

        Story story = storyRepository.findById(storyId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND,
                        "Story not found"));

        UserStoryRatingId id = new UserStoryRatingId(userId, storyId);
        UserStoryRating rating = ratingRepository.findById(id)
                .orElse(new UserStoryRating());

        rating.setId(id);
        rating.setUser(user);
        rating.setStory(story);
        rating.setRating(ratingValue);

        ratingRepository.save(rating);
        updateAverageRating(story);

    }

    private void updateAverageRating(Story story) {
        List<UserStoryRating> ratings = ratingRepository.findByStory(story);
        if (ratings.isEmpty()) {
            story.setAverageRating(0.0);
        } else {
            double avg = ratings.stream()
                    .mapToDouble(UserStoryRating::getRating)
                    .average()
                    .orElse(0.0);
            story.setAverageRating(avg);
        }
        storyRepository.save(story);
    }

    public Double getUserStoryRating(UUID userId, UUID storyId) {

        UserStoryRatingId id = new UserStoryRatingId(userId, storyId);
        Optional<UserStoryRating> rating = ratingRepository.findById(id);

        return rating.map(UserStoryRating::getRating).orElse(null);
    }
}

