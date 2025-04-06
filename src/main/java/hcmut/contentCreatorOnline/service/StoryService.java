package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.genre.GenreResult;
import hcmut.contentCreatorOnline.dto.story.CreateStoryRequest;
import hcmut.contentCreatorOnline.dto.story.CreateStoryResult;
import hcmut.contentCreatorOnline.dto.story.StoryDTO;
import hcmut.contentCreatorOnline.dto.story.UpdateStoryGenreResult;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.Genre;
import hcmut.contentCreatorOnline.model.Story;
import hcmut.contentCreatorOnline.repository.GenreRepository;
import hcmut.contentCreatorOnline.repository.StoryRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class StoryService {

    private final StoryRepository storyRepository;

    private final GenreRepository genreRepository;

    private StoryDTO mapToDTO(Story story) {
        return StoryDTO.builder()
                //.storyId(story.getStoryId()
                .storyTitle(story.getStoryTitle())
                .storyDescription(story.getStoryDescription())
                .coverImageUri(story.getCoverImageUri())
                .releaseDate(story.getReleaseDate())
                .releaseDate(story.getReleaseDate())
                .createdDate(story.getCreatedDate())
                .releaseStatus(story.getReleaseStatus())
                .saleOnly(story.getSaleOnly())
                .salePrice(story.getSalePrice())
                .numberOfLikes(story.getNumberOfLikes())
                .tags(story.getTags())
                .chapters(story.getChapters())
                .genres(story.getGenres())
                .readLists(story.getReadLists())
                .orders(story.getOrders())
                .userPost(story.getUserPost())
                .build();
    }

    public StoryService(StoryRepository storyRepository, GenreRepository genreRepository) {
        this.storyRepository = storyRepository;
        this.genreRepository = genreRepository;
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

    public List<StoryDTO> getStoriesPostedByUser(UUID userId) {
        List<Story> stories = storyRepository.findByUserPost_Id(userId);
        return stories.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public StoryDTO getStoryByStoryId(UUID storyId){
        Story story = storyRepository.findById(storyId)
                .orElseThrow(() -> new RuntimeException("Story not found with ID: " + storyId));
        return mapToDTO(story);
    }
}
