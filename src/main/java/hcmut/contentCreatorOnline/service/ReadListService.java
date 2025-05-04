package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.readList.CreateNewReadListRequest;
import hcmut.contentCreatorOnline.dto.readList.DeleteStoriesFromReadListResponse;
import hcmut.contentCreatorOnline.dto.readList.ReadListDTO;
import hcmut.contentCreatorOnline.dto.story.StoryDTO;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.ReadList;
import hcmut.contentCreatorOnline.model.Story;
import hcmut.contentCreatorOnline.model.User;
import hcmut.contentCreatorOnline.model.UserPrincipal;
import hcmut.contentCreatorOnline.repository.ReadListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static hcmut.contentCreatorOnline.utils.SecurityUtils.getCurrentUser;

@Service
@RequiredArgsConstructor
public class ReadListService {

    private final ReadListRepository readListRepository;

    public List<ReadListDTO> getReadListByUserId(UUID userId) {
        try {
            if (userId == null) {
                throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "userId cannot be null");
            }

            return readListRepository.findAllByUserCreated_Id(userId).stream().map(
                    readList -> new ReadListDTO(
                            readList.getReadListId(),
                            readList.getReadListTitle(),
                            readList.getDescription(),
                            readList.getStories().size(),
                            readList.getUserCreated().getId()
                    )).toList();

        } catch (IllegalArgumentException e) {
            throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "userId cannot be null");
        }
    }

    public List<StoryDTO> getTopStoriesInReadList(UUID readListId, int amount) {
        try {
            if (readListId == null) {
                throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "readListId cannot be null");
            }

            return readListRepository.findById(readListId)
                    .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Read list not found"))
                    .getStories()
                    .stream()
                    .sorted((s1, s2) -> Double.compare(s2.getAverageRating(), s1.getAverageRating()))
                    .limit(amount)
                    .map(story -> StoryDTO.builder()
                            .storyId(story.getStoryId())
                            .storyTitle(story.getStoryTitle())
                            .storyDescription(story.getStoryDescription())
                            .coverImageUri(story.getCoverImageUri())
                            .userPost(story.getUserPost().getId().toString())
                            .numberOfViews(story.getNumberOfViews())
                            .averageRating(story.getAverageRating())
                            .build()
                    ).toList();

        } catch (IllegalArgumentException e) {
            throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "readListId cannot be null");
        }
    }

    public void deleteReadListById(UUID readListId) {
        if (readListId == null) {
            throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "readListId cannot be null");
        }

        try {
            readListRepository.deleteById(readListId);
        } catch (IllegalArgumentException e) {
            throw new ApplicationException(
                    ErrorConst.UNEXPECTED_ERROR,
                    String.format("Failed to delete read list with id %s", readListId)
            );
        }
    }

    public ReadListDTO createNewReadList(CreateNewReadListRequest request) {
        if (request == null) {
            throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "request cannot be null");
        }

        if (request.getReadListTitle() == null || request.getReadListTitle().isEmpty()) {
            throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "readListTitle cannot be null or empty");
        }

        UserPrincipal currentUser = getCurrentUser();

        User userCreated = User.builder().id(currentUser.getId()).build();

        ReadList readList = ReadList.builder()
                .readListTitle(request.getReadListTitle())
                .description(request.getReadListDescription())
                .userCreated(userCreated)
                .build();

        ReadList saveResult = readListRepository.save(readList);


        return ReadListDTO.builder()
                .read_list_id(saveResult.getReadListId())
                .read_list_title(saveResult.getReadListTitle())
                .read_list_description(saveResult.getDescription())
                .number_of_stories(saveResult.getStories() == null ? 0 : saveResult.getStories().size())
                .user_id(saveResult.getUserCreated().getId())
                .build();
    }

    public List<StoryDTO> getAllStoriesByReadListId(UUID readListId) {
        if (readListId == null) {
            throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "readListId cannot be null");
        }

        ReadList readList = readListRepository.findById(readListId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Read list not found"));

        return readList.getStories()
                .stream()
                .map(story -> StoryDTO.builder()
                        .storyId(story.getStoryId())
                        .storyTitle(story.getStoryTitle())
                        .storyDescription(story.getStoryDescription())
                        .coverImageUri(story.getCoverImageUri())
                        .userPost(story.getUserPost().getFirstName() + " " + story.getUserPost().getLastName())
                        .numberOfViews(story.getNumberOfViews())
                        .averageRating(story.getAverageRating())
                        .numberOfChapters(story.getChapters().size())
                        .build()
                ).toList();
    }

    public DeleteStoriesFromReadListResponse deleteStoriesFromReadList(UUID readListId, List<UUID> storyIds) {
        if (readListId == null) {
            throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "readListId cannot be null");
        }

        if (storyIds == null || storyIds.isEmpty()) {
            throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "storyIds cannot be null or empty");
        }

        ReadList readList = readListRepository.findById(readListId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Read list not found"));

        List<Story> storiesToRemove = readList.getStories()
                .stream()
                .filter(story -> storyIds.contains(story.getStoryId()))
                .toList();

        readList.getStories().removeAll(storiesToRemove);
        ReadList result = readListRepository.save(readList);

        return new DeleteStoriesFromReadListResponse(result.getReadListId());
    }

    public ReadListDTO getReadListById(UUID readListId) {
        if (readListId == null) {
            throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "readListId cannot be null");
        }

        ReadList readList = readListRepository.findById(readListId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Read list not found"));

        return ReadListDTO.builder()
                .read_list_id(readList.getReadListId())
                .read_list_title(readList.getReadListTitle())
                .read_list_description(readList.getDescription())
                .number_of_stories(readList.getStories() == null ? 0 : readList.getStories().size())
                .user_id(readList.getUserCreated().getId())
                .build();
    }

}
