package hcmut.contentCreatorOnline.controller.readList;

import hcmut.contentCreatorOnline.dto.readList.*;
import hcmut.contentCreatorOnline.dto.story.StoryDTO;
import hcmut.contentCreatorOnline.model.UserPrincipal;
import hcmut.contentCreatorOnline.service.ReadListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static hcmut.contentCreatorOnline.utils.SecurityUtils.getCurrentUser;

@RestController
@RequestMapping("/read_list")
@RequiredArgsConstructor
public class ReadListController {

    private final ReadListService readListService;

    @GetMapping("/user/{user_id}")
    public ResponseEntity<ReadList_ListResponse> getReadListByUserId(@PathVariable UUID user_id) {

        List<ReadListDTO> result = readListService.getReadListByUserId(user_id);
        return ResponseEntity.ok(new ReadList_ListResponse(HttpStatus.OK.value(), result));
    }

    @GetMapping("/current_user")
    public ResponseEntity<ReadList_ListResponse> getReadListByCurrentUser() {
        UserPrincipal current_user = getCurrentUser();
        List<ReadListDTO> result = readListService.getReadListByUserId(current_user.getId());
        return ResponseEntity.ok(new ReadList_ListResponse(HttpStatus.OK.value(), result));
    }

    @GetMapping("/top_stories/{read_list_id}")
    public ResponseEntity<ReadListTopStoriesResponse> getTopStoriesInReadList(
            @PathVariable UUID read_list_id,
            @RequestParam(defaultValue = "3") int amount) {
        List<StoryDTO> result = readListService.getTopStoriesInReadList(read_list_id, amount);

        return ResponseEntity.ok(new ReadListTopStoriesResponse(HttpStatus.OK.value(), result));
    }

    @DeleteMapping("/{read_list_id}")
    public ResponseEntity<DeleteReadListResponse> deleteReadListById(@PathVariable UUID read_list_id) {
        readListService.deleteReadListById(read_list_id);

        return ResponseEntity.ok(new DeleteReadListResponse(HttpStatus.OK.value()));
    }

    @PostMapping("/new")
    public ResponseEntity<CreateNewReadListResponse> createNewReadList(@RequestBody CreateNewReadListRequest request) {

        ReadListDTO newReadList = readListService.createNewReadList(request);

        return ResponseEntity.ok(new CreateNewReadListResponse(HttpStatus.CREATED.value(), newReadList));
    }

    @GetMapping("/stories/{read_list_id}")
    public ResponseEntity<GetStoriesByReadListIdResponse> getAllStoriesByReadListId(@PathVariable UUID read_list_id) {
        List<StoryDTO> stories = readListService.getAllStoriesByReadListId(read_list_id);
        return ResponseEntity.ok(new GetStoriesByReadListIdResponse(HttpStatus.OK.value(), stories));
    }

    @DeleteMapping("/delete_stories/{read_list_id}")
    public ResponseEntity<DeleteStoriesFromReadListResponse> deleteStoriesFromReadList(
            @PathVariable UUID read_list_id,
            @RequestBody DeleteStoriesFromReadList storyIds) {

        DeleteStoriesFromReadListResponse result = readListService.deleteStoriesFromReadList(read_list_id, storyIds.getStoryIds());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/specific/{read_list_id}")
    public ResponseEntity<ReadListDTO> getReadListById(@PathVariable UUID read_list_id) {
        ReadListDTO readList = readListService.getReadListById(read_list_id);
        return ResponseEntity.ok(readList);
    }

    @PutMapping("/update/{read_list_id}")
    public ResponseEntity<ReadListDTO> updateReadList(
            @RequestBody UpdateReadListRequest request,
            @PathVariable UUID read_list_id) {

        ReadListDTO updatedReadList = readListService.updateReadList(read_list_id, request);
        return ResponseEntity.ok(updatedReadList);
    }


    @PostMapping("/add_story/{story_id}")
    public ResponseEntity<AddStoryToManyReadListResponse> addStoryToManyReadList(
            @PathVariable UUID story_id,
            @RequestBody AddStoryToManyReadListRequest request) {

        List<UUID> result = readListService.addStoryToManyReadList(story_id, request.getRead_list_ids());
        return ResponseEntity.ok(new AddStoryToManyReadListResponse(story_id, result));
    }


}
