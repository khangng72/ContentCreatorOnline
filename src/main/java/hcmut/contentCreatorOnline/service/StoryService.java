package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.genre.GenreResult;
import hcmut.contentCreatorOnline.dto.story.*;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.*;
import hcmut.contentCreatorOnline.repository.GenreRepository;
import hcmut.contentCreatorOnline.repository.StoryRepository;
import hcmut.contentCreatorOnline.repository.UserRepository;
import hcmut.contentCreatorOnline.utils.SecurityUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class StoryService {

    private final StoryRepository storyRepository;
    private final GenreRepository genreRepository;
    private final EntityManager entityManager;
    private final UserRepository userRepository;
    @Value("${spring.application.fuzzy-search.threshold}")
    private double threshold;

    public StoryService(StoryRepository storyRepository, GenreRepository genreRepository, EntityManager entityManager, UserRepository userRepository) {
        this.storyRepository = storyRepository;
        this.genreRepository = genreRepository;
        this.entityManager = entityManager;
        this.userRepository = userRepository;
    }

    private StoryDTO mapToStoryDTO(Story story) {
        return StoryDTO.builder()
                .storyId(story.getStoryId())
                .storyTitle(story.getStoryTitle())
                .storyDescription(story.getStoryDescription())
                .coverImageUri(story.getCoverImageUri())
                .userPost(story.getUserPost().getFirstName() + " " + story.getUserPost().getLastName())
                .userId(story.getUserPost().getId())
                .numberOfViews(story.getUserReadStory().size())
                .numberOfChapters(story.getChapters().size())
                .averageRating(story.getAverageRating())
                .updatedTime(story.getUpdatedTime())
                .createdTime(story.getCreatedTime())
                .genres(
                        story.getGenres().stream()
                                .map(genre -> GenreResult.builder()
                                        .genreId(genre.getGenreId())
                                        .genreName(genre.getGenreName())
                                        .build()
                                )
                                .toList()
                )
                .build();
    }

    private StoryResponse mapToDTO(Story story) {
        return StoryResponse.builder()
                .storyId(story.getStoryId())
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
                .userPost(story.getUserPost().getFirstName() + " " + story.getUserPost().getLastName())
                .numberOfViews(story.getNumberOfViews())
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
        story.setReleaseStatus(false);

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
                .map(this::mapToStoryDTO
                ).toList();
    }

    public List<StoryResponse> getLatestStoriesPostedByUser(UUID userId) {
        List<Story> stories = storyRepository.findTop10ByUserPost_IdOrderByCreatedTimeDesc(userId);
        return stories.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public StoryResponse getStoryByStoryId(UUID storyId) {
        Story story = storyRepository.findById(storyId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Story not found with ID: " + storyId));

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

        return StoryResponse.builder()
                .storyId(story.getStoryId())
                .releaseDate(story.getReleaseDate())
                .createdDate(story.getCreatedDate())
                .releaseStatus(story.getReleaseStatus())
                .storyTitle(story.getStoryTitle())
                .saleOnly(story.getSaleOnly())
                .salePrice(story.getSalePrice())
                .numberOfLikes(story.getNumberOfLikes())
                .coverImageUri(story.getCoverImageUri())
                .storyDescription(story.getStoryDescription())
                .tags(story.getTags())
                .averageRating(story.getAverageRating())
                .userId(story.getUserPost().getId())
                .chapters(chapterList)
                .build()
                ;
    }

    public List<StoryDTO> getStoriesByGenreId(Integer genreId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Story> stories = storyRepository.findByGenreId(genreId, pageable);

        return stories.getContent().stream()
                .map(this::mapToStoryDTO
                )
                .toList();
    }

    private String buildSearchQuery(String sortBy, String order) {
        String validSortBy = switch (sortBy) {
            case "createdDate" -> "created_date";
            case "averageRating" -> "average_rating";
            default -> throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "Invalid sortBy: " + sortBy);
        };

        String validOrder = switch (order.toUpperCase()) {
            case "ASC", "DESC" -> order.toUpperCase();
            default -> throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "Invalid order: " + order);
        };

        return """
                 SELECT story_id FROM story
                        WHERE (similarity(story_title, :query) > :threshold
                           OR document @@ plainto_tsquery('english', :query))
                        AND release_status = true
                        ORDER BY
                            ts_rank(document, plainto_tsquery('english', :query)) DESC,
                            similarity(story_title, :query) DESC,
                            %s %s
                        OFFSET :offset LIMIT :limit
                """.formatted(validSortBy, validOrder);
    }

    public List<StoryDTO> fuzzySearchStoriesByQueryString(
            String searchTitle,
            int page,
            int size,
            String sortBy,
            String sortDirection) {

        String sqlQuery = buildSearchQuery(sortBy, sortDirection);

        List<?> rawList = entityManager.createNativeQuery(sqlQuery, Tuple.class)
                .setParameter("query", searchTitle)
                .setParameter("offset", page * size)
                .setParameter("limit", size)
                .setParameter("threshold", threshold)
                .getResultList();

        List<Tuple> tuples = rawList.stream()
                .map(Tuple.class::cast)
                .toList();
        List<UUID> storyIds = tuples.stream()
                .map(t -> t.get("story_id", UUID.class))
                .toList();

        List<Story> stories = new ArrayList<>();
        for (UUID storyId : storyIds) {
            Story story = storyRepository.findById(storyId)
                    .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Story not found with ID: " + storyId));
            if (!story.getReleaseStatus()) {
                throw new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Story not found with ID: " + storyId);
            }
            stories.add(story);
        }

        return stories.stream()
                .map(this::mapToStoryDTO
                )
                .toList();
    }


    public StoryDTO getStoryBasicInfoByStoryId(UUID storyId) {
        Story story = storyRepository.findById(storyId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Story not found with ID: " + storyId));

        return mapToStoryDTO(story);
    }


    public List<CurrentReadDTO> getCurrentReading() {
        UserPrincipal principal = SecurityUtils.getCurrentUser();
        User user = userRepository.findById(principal.getId())
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "User not found"));

        Set<UserReadStory> userReadStories = user.getUserReadStory();

        return userReadStories.stream()
                .map(
                        userReadStory -> CurrentReadDTO.builder()
                                .storyId(userReadStory.getStory().getStoryId())
                                .storyTitle(userReadStory.getStory().getStoryTitle())
                                .storyDescription(userReadStory.getStory().getStoryDescription())
                                .coverImageUri(userReadStory.getStory().getCoverImageUri())
                                .userPost(userReadStory.getStory().getUserPost().getFirstName() + " " + userReadStory.getStory().getUserPost().getLastName())
                                .userId(userReadStory.getStory().getUserPost().getId())
                                .numberOfViews(userReadStory.getStory().getUserReadStory().size())
                                .numberOfChapters(userReadStory.getStory().getChapters().size())
                                .currentChapterId(userReadStory.getChapterId())
                                .averageRating(userReadStory.getStory().getAverageRating())
                                .build()
                ).toList();
    }

    public List<StoryDTO> getPublishedStories() {
        UserPrincipal principal = SecurityUtils.getCurrentUser();
        User user = userRepository.findById(principal.getId())
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "User not found"));

        List<Story> stories = storyRepository
                .findByUserPost_IdAndReleaseStatusOrderByUpdatedTimeDesc(user.getId(), true);
        return stories.stream()
                .map(this::mapToStoryDTO
                ).toList();
    }

    public void deleteStory(UUID storyId) {
        Story story = storyRepository.findById(storyId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Story not found with ID: " + storyId));

        // Check if the user is the owner of the story
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        if (!story.getUserPost().getId().equals(currentUser.getId())) {
            throw new ApplicationException(ErrorConst.FORBIDDEN, "You are not authorized to delete this story");
        }

        // Delete the story
        storyRepository.delete(story);
    }

    public PublishedInfo getPublishedInfo(UUID storyId) {
        Story story = storyRepository.findById(storyId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Story not found with ID: " + storyId));

        // Check if the user is the owner of the story
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        if (!story.getUserPost().getId().equals(currentUser.getId())) {
            throw new ApplicationException(ErrorConst.FORBIDDEN, "You are not authorized to get published info for this story");
        }

        Integer published = story.getChapters().stream().filter(Chapter::getIsPublished).toList().size();
        Integer draft = story.getChapters().stream().filter(chapter -> !chapter.getIsPublished()).toList().size();

        return PublishedInfo.builder()
                .storyId(story.getStoryId())
                .published(published)
                .draft(draft)
                .build();
    }

    public void unpublishStory(UUID storyId) {
        Story story = storyRepository.findById(storyId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Story not found with ID: " + storyId));

        // Check if the user is the owner of the story
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        if (!story.getUserPost().getId().equals(currentUser.getId())) {
            throw new ApplicationException(ErrorConst.FORBIDDEN, "You are not authorized to unpublish this story");
        }

        // Unpublish the story
        story.setReleaseStatus(false);
        for (Chapter chapter : story.getChapters()) {
            chapter.setIsPublished(false);
        }
        storyRepository.save(story);
    }

    public List<StoryDTO> getAllStoriesByCurrentUser() {
        UserPrincipal principal = SecurityUtils.getCurrentUser();
        User user = userRepository.findById(principal.getId())
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "User not found"));

        List<Story> stories = storyRepository.findByUserPost_IdOrderByUpdatedTimeDesc(user.getId());
        return stories.stream()
                .map(this::mapToStoryDTO
                ).toList();
    }

    public void publishStory(UUID storyId) {
        Story story = storyRepository.findById(storyId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Story not found with ID: " + storyId));

        // Check if the user is the owner of the story
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        if (!story.getUserPost().getId().equals(currentUser.getId())) {
            throw new ApplicationException(ErrorConst.FORBIDDEN, "You are not authorized to publish this story");
        }

        // Unpublish the story
        story.setReleaseStatus(true);
        for (Chapter chapter : story.getChapters()) {
            chapter.setIsPublished(true);
        }
        storyRepository.save(story);
    }

    public void updateStoryInfo(UUID storyId, UpdateStoryRequest updateStoryRequest) {

        Story story = storyRepository.findById(storyId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Story not found with ID: " + storyId));

        // Check if the user is the owner of the story
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        if (!story.getUserPost().getId().equals(currentUser.getId())) {
            throw new ApplicationException(ErrorConst.FORBIDDEN, "You are not authorized to update this story");
        }

        // Update the story information
        if (updateStoryRequest.getStoryTitle() != null) {
            story.setStoryTitle(updateStoryRequest.getStoryTitle());
        }

        if (updateStoryRequest.getStoryDescription() != null) {
            story.setStoryDescription(updateStoryRequest.getStoryDescription());
        }

        if (updateStoryRequest.getCoverImageUri() != null) {
            story.setCoverImageUri(updateStoryRequest.getCoverImageUri());
        }

        if (updateStoryRequest.getGenres() != null) {
            updateStoryGenres(story.getStoryId(), updateStoryRequest.getGenres());
        }

        // Save the updated story
        storyRepository.save(story);
    }
}
