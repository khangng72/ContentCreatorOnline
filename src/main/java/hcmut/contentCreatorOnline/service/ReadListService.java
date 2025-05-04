package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.readList.ReadListDTO;
import hcmut.contentCreatorOnline.dto.story.StoryDTO;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.repository.ReadListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

}
