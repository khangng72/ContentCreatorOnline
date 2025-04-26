package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.genre.GenreResult;
import hcmut.contentCreatorOnline.dto.story.*;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.*;
import hcmut.contentCreatorOnline.repository.GenreRepository;
import hcmut.contentCreatorOnline.repository.StoryRepository;
import hcmut.contentCreatorOnline.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class StoryService {

    private final StoryRepository storyRepository;

    private final GenreRepository genreRepository;

    public StoryService(StoryRepository storyRepository, GenreRepository genreRepository) {
        this.storyRepository = storyRepository;
        this.genreRepository = genreRepository;
    }

    private StoryResponse mapToDTO(Story story) {
        return StoryResponse.builder()
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
//                .chapters(story.getChapters())
//                .genres(story.getGenres())
//                .readLists(story.getReadLists())
//                .orders(story.getOrders())
//                .userPost(story.getUserPost())
                .averageRating(story.getAverageRating())
                .build();
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
        story.setReleaseDate(createStoryRequest.getReleaseDate());

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

    public List<StoryResponse> getStoriesPostedByUser(UUID userId) {
        List<Story> stories = storyRepository.findByUserPost_Id(userId);
        return stories.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public StoryResponse getStoryByStoryId(UUID storyId) {
        Story story = storyRepository.findById(storyId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Story not found with ID: " + storyId));

        if (!story.getReleaseStatus()) {
            throw new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Story not found with ID: " + storyId);
        }

        List<ChapterStoryResponse> chapterList = story.getChapters().stream()
                .sorted(Comparator.comparingInt(Chapter::getChapterNumber))
                .map(
                        chapter -> new ChapterStoryResponse(
                                chapter.getChapterId(),
                                chapter.getChapterTitle(),
                                chapter.getChapterDescription(),
                                chapter.getChapterContent(),
                                chapter.getChapterImageUri(),
                                chapter.getChapterNumber()
                        )
                ).toList();


        return new StoryResponse(
                story.getStoryId(),
                story.getReleaseDate(),
                story.getCreatedDate(),
                story.getReleaseStatus(),
                story.getStoryTitle(),
                story.getSaleOnly(),
                story.getSalePrice(),
                story.getNumberOfLikes(),
                story.getCoverImageUri(),
                story.getStoryDescription(),
                story.getTags(),
                story.getAverageRating(),
                story.getUserPost().getId(),
                chapterList
        );
    }


}
