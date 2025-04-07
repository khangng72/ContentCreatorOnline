package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.genre.GenreResult;
import hcmut.contentCreatorOnline.dto.story.CreateStoryRequest;
import hcmut.contentCreatorOnline.dto.story.CreateStoryResult;
import hcmut.contentCreatorOnline.dto.story.UpdateStoryGenreResult;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.Genre;
import hcmut.contentCreatorOnline.model.Story;
import hcmut.contentCreatorOnline.model.User;
import hcmut.contentCreatorOnline.model.UserPrincipal;
import hcmut.contentCreatorOnline.repository.GenreRepository;
import hcmut.contentCreatorOnline.repository.StoryRepository;
import hcmut.contentCreatorOnline.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Service
public class StoryService {

    private final StoryRepository storyRepository;

    private final GenreRepository genreRepository;

    public StoryService(StoryRepository storyRepository, GenreRepository genreRepository) {
        this.storyRepository = storyRepository;
        this.genreRepository = genreRepository;
    }

    public CreateStoryResult createNewStory(CreateStoryRequest createStoryRequest) {

        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        UUID userId = currentUser.getId();

        User creator = new User();
        creator.setId(userId);

        Story story = new Story();
        story.setStoryTitle(createStoryRequest.getStoryTitle());
        story.setSaleOnly(createStoryRequest.getSaleOnly());
        story.setSalePrice(createStoryRequest.getSalePrice());
        story.setCoverImageUri(createStoryRequest.getCoverImageUri());
        story.setStoryDescription(createStoryRequest.getStoryDescription());
        story.setUserPost(creator);

        Story saveStoryResult = storyRepository.save(story);
        return new CreateStoryResult(saveStoryResult.getStoryId());
    }

    public UpdateStoryGenreResult updateStoryGenres(UUID storyId, List<GenreResult> genreList) {
        // Check if story exists, if not throw ApplicationException
        Story story = storyRepository.findById(storyId).orElse(null);
        if (story == null) {
            throw new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Genre not found");
        }

        // Empty genre list of story
        Set<Genre> newGenreList = new HashSet<>();

        // Assign genre list to story
        for (GenreResult genreRequest : genreList) {
            Genre genre = genreRepository.findById(genreRequest.getGenreId()).orElse(null);
            if (genre == null) {
                throw new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Genre not found");
            }

            newGenreList.add(genre);
        }

        story.setGenres(newGenreList);
        Story result = storyRepository.save(story);

        return new UpdateStoryGenreResult(result.getStoryId());
    }

}
