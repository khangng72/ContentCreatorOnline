package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.story.CreateStoryRequest;
import hcmut.contentCreatorOnline.dto.story.CreateStoryResult;
import hcmut.contentCreatorOnline.model.Story;
import hcmut.contentCreatorOnline.repository.StoryRepository;
import org.springframework.stereotype.Service;


@Service
public class StoryService {

    private final StoryRepository storyRepository;

    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public CreateStoryResult createNewStory(CreateStoryRequest createStoryRequest) {

        Story story = new Story();
        story.setStoryTitle(createStoryRequest.getStoryTitle());
        story.setSaleOnly(createStoryRequest.getSaleOnly());
        story.setSalePrice(createStoryRequest.getSalePrice());
        story.setCoverImageUri(createStoryRequest.getCoverImageUri());
        story.setStoryDescription(createStoryRequest.getStoryDescription());

        Story saveStoryResult = storyRepository.save(story);
        return new CreateStoryResult(saveStoryResult.getStoryId());
    }


}
