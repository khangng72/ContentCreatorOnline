package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.readList.CreateNewReadListRequest;
import hcmut.contentCreatorOnline.dto.readList.DeleteStoriesFromReadListResponse;
import hcmut.contentCreatorOnline.dto.readList.ReadListDTO;
import hcmut.contentCreatorOnline.dto.readList.UpdateReadListRequest;
import hcmut.contentCreatorOnline.dto.story.StoryDTO;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.ReadList;
import hcmut.contentCreatorOnline.model.Story;
import hcmut.contentCreatorOnline.model.User;
import hcmut.contentCreatorOnline.model.UserPrincipal;
import hcmut.contentCreatorOnline.repository.ReadListRepository;
import hcmut.contentCreatorOnline.repository.StoryRepository;
import hcmut.contentCreatorOnline.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static hcmut.contentCreatorOnline.utils.SecurityUtils.getCurrentUser;

@Service
@RequiredArgsConstructor
public class ReadListService {

    private final ReadListRepository readListRepository;

    private final StoryRepository storyRepository;

    public List<ReadListDTO> getReadListByUserId(UUID userId) {
        try {
            if (userId == null) {
                throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "userId cannot be null");
            }

            return readListRepository.findAllByUserCreated_Id(userId).stream().map(
                    readList -> ReadListDTO.builder()
                            .read_list_id(readList.getReadListId())
                            .read_list_title(readList.getReadListTitle())
                            .read_list_description(readList.getDescription())
                            .number_of_stories(readList.getStories() == null ? 0 : readList.getStories().size())
                            .user_id(readList.getUserCreated().getId())
                            .story_ids(readList.getStories().stream().map(Story::getStoryId).toList()).build()
            ).toList();

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
                .user_name(readList.getUserCreated().getFirstName() + " " + readList.getUserCreated().getLastName())
                .build();
    }

    public ReadListDTO updateReadList(UUID readListId, UpdateReadListRequest request) {
        if (readListId == null) {
            throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "readListId cannot be null");
        }

        if (request == null) {
            throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "request cannot be null");
        }

        ReadList readList = readListRepository.findById(readListId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Read list not found"));

        if (request.getReadListTitle() != null && !request.getReadListTitle().isEmpty()) {
            readList.setReadListTitle(request.getReadListTitle());
        }

        if (request.getReadListDescription() != null && !request.getReadListDescription().isEmpty()) {
            readList.setDescription(request.getReadListDescription());
        }

        ReadList updatedReadList = readListRepository.save(readList);

        return ReadListDTO.builder()
                .read_list_id(updatedReadList.getReadListId())
                .read_list_title(updatedReadList.getReadListTitle())
                .read_list_description(updatedReadList.getDescription())
                .number_of_stories(updatedReadList.getStories() == null ? 0 : updatedReadList.getStories().size())
                .user_id(updatedReadList.getUserCreated().getId())
                .build();
    }

    public List<UUID> addStoryToManyReadList(UUID storyId, List<UUID> readListIds) {
        if (storyId == null) {
            throw new ApplicationException(ErrorConst.ILLEGAL_ARGUMENT, "storyId cannot be null");
        }

        Story story = storyRepository.findById(storyId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Story not found"));

        // Step 1: Clear story from old readLists (bidirectional cleanup)
        for (ReadList oldReadList : story.getReadLists()) {
            oldReadList.getStories().remove(story);
        }

        // Step 2: If readListIds is empty or null, clear all read lists
        if (readListIds == null || readListIds.isEmpty()) {
            story.getReadLists().clear(); // or story.setReadLists(new ArrayList<>());
            storyRepository.save(story);  // Save the inverse side
            return Collections.emptyList();
        }

        // Step 3: Fetch new readLists
        List<ReadList> newReadLists = readListRepository.findAllById(readListIds);

        if (newReadLists.size() != readListIds.size()) {
            throw new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Some read lists not found");
        }

        // Step 4: Set new readLists on the story
        story.setReadLists(newReadLists);

        // Step 5: Add the story to each new readList (owning side)
        for (ReadList newReadList : newReadLists) {
            if (!newReadList.getStories().contains(story)) {
                newReadList.getStories().add(story);
            }
        }

        // Step 6: Save owning side to persist changes
        readListRepository.saveAll(newReadLists);

        return newReadLists.stream()
                .map(ReadList::getReadListId)
                .toList();
    }

    public String cloneReadListToCurrentUserLibrary(UUID readListId) {
        UserPrincipal currentUser = SecurityUtils.getCurrentUser();
        UUID userId = currentUser.getId();

        User user = User.builder().id(userId).build();

        ReadList readList = readListRepository.findById(readListId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Read list not found with ID: " + readListId));

        List<Story> clonedStories = readList.getStories().stream()
                .map(story -> Story.builder()
                        .storyId(story.getStoryId()).build()) // or clone manually
                .toList();

        ReadList newReadList = ReadList.builder()
                .readListTitle(readList.getReadListTitle() + " (copy)")
                .description(readList.getDescription())
                .stories(clonedStories)
                .userCreated(user)
                .build();

        readListRepository.save(newReadList);


        return "Clone read list successfully";
    }
}
