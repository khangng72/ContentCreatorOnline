package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.userReadStory.TrackReadRequest;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.*;
import hcmut.contentCreatorOnline.repository.StoryRepository;
import hcmut.contentCreatorOnline.repository.UserReadStoryRepository;
import hcmut.contentCreatorOnline.repository.UserRepository;
import hcmut.contentCreatorOnline.utils.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserReadStoryService {

    private final UserReadStoryRepository userReadStoryRepository;
    private final UserRepository userRepository;
    private final StoryRepository storyRepository;

    public String trackReadStory(TrackReadRequest request) {
        UserPrincipal principal = SecurityUtils.getCurrentUser();

        User user = userRepository.findById(principal.getId())
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "User not found"));

        Story story = storyRepository.findById(request.getStoryId())
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Story not found"));

        UserReadStoryId key = new UserReadStoryId(user.getId(), story.getStoryId());

        userReadStoryRepository.findById(key).ifPresentOrElse(existing -> {
            existing.setChapterId(request.getChapterId());
            userReadStoryRepository.save(existing);
        }, () -> {
            UserReadStory newEntry = new UserReadStory();
            newEntry.setId(key);
            newEntry.setUser(user);
            newEntry.setStory(story);
            newEntry.setChapterId(request.getChapterId());
            userReadStoryRepository.save(newEntry);
        });

        return "User read story tracked successfully";
    }
}

