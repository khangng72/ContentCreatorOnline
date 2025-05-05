package hcmut.contentCreatorOnline.dto.readList;

import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AddStoryToManyReadListRequest {
    private List<UUID> read_list_ids;
}
