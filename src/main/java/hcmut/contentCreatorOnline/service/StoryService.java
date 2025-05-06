package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.genre.GenreResult;
import hcmut.contentCreatorOnline.dto.story.*;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.*;
import hcmut.contentCreatorOnline.repository.GenreRepository;
import hcmut.contentCreatorOnline.repository.StoryRepository;
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
    @Value("${spring.application.fuzzy-search.threshold}")
    private double threshold;

    public StoryService(StoryRepository storyRepository, GenreRepository genreRepository, EntityManager entityManager) {
        this.storyRepository = storyRepository;
        this.genreRepository = genreRepository;
        this.entityManager = entityManager;
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

    public List<StoryResponse> getLatestStoriesPostedByUser(UUID userId) {
        List<Story> stories = storyRepository.findTop10ByUserPost_IdOrderByCreatedTimeDesc(userId);
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


        // return StoryResponse(
        //         story.getStoryId(),
        //         story.getReleaseDate(),
        //         story.getCreatedDate(),
        //         story.getReleaseStatus(),
        //         story.getStoryTitle(),
        //         story.getSaleOnly(),
        //         story.getSalePrice(),
        //         story.getNumberOfLikes(),
        //         story.getCoverImageUri(),
        //         story.getStoryDescription(),
        //         story.getTags(),
        //         story.getAverageRating(),
        //         story.getUserPost().getId(),
        //         chapterList
        // );

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

        return stories.getContent().stream().map(
                story -> new StoryDTO(
                        story.getStoryId(),
                        story.getStoryTitle(),
                        story.getStoryDescription(),
                        story.getCoverImageUri(),
                        story.getUserPost().getFirstName() + " " + story.getUserPost().getLastName(),
                        story.getNumberOfViews(),
                        story.getChapters().size(),
                        story.getAverageRating(),
                        story.getGenres().stream().map(
                                genre -> new GenreResult(
                                        genre.getGenreId(),
                                        genre.getGenreName()
                                )
                        ).toList()
                )
        ).toList();
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
                        WHERE similarity(story_title, :query) > :threshold
                           OR document @@ plainto_tsquery('english', :query)
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

        return stories.stream().map(
                story -> new StoryDTO(
                        story.getStoryId(),
                        story.getStoryTitle(),
                        story.getStoryDescription(),
                        story.getCoverImageUri(),
                        story.getUserPost().getFirstName() + " " + story.getUserPost().getLastName(),
                        story.getNumberOfViews(),
                        story.getChapters().size(),
                        story.getAverageRating(),
                        story.getGenres().stream().map(
                                genre -> new GenreResult(
                                        genre.getGenreId(),
                                        genre.getGenreName()
                                )
                        ).toList()
                )
        ).toList();
    }


    public StoryDTO getStoryBasicInfoByStoryId(UUID storyId) {
        Story story = storyRepository.findById(storyId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Story not found with ID: " + storyId));

        return new StoryDTO(
                story.getStoryId(),
                story.getStoryTitle(),
                story.getStoryDescription(),
                story.getCoverImageUri(),
                story.getUserPost().getFirstName() + " " + story.getUserPost().getLastName(),
                story.getNumberOfViews(),
                story.getChapters().size(),
                story.getAverageRating(),
                story.getGenres().stream().map(
                        genre -> new GenreResult(
                                genre.getGenreId(),
                                genre.getGenreName()
                        )
                ).toList()
        );
    }
}
