package hcmut.contentCreatorOnline.controller.readList;

import hcmut.contentCreatorOnline.dto.readList.ReadListDTO;
import hcmut.contentCreatorOnline.dto.readList.ReadList_ListResponse;
import hcmut.contentCreatorOnline.model.UserPrincipal;
import hcmut.contentCreatorOnline.service.ReadListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static hcmut.contentCreatorOnline.utils.SecurityUtils.getCurrentUser;

@RestController
@RequestMapping("/read_list")
@RequiredArgsConstructor
public class ReadListController {

    private final ReadListService readListService;

    @GetMapping("/{user_id}")
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
}
