package hcmut.contentCreatorOnline.dto.readList;

import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AddStoryToManyReadListResponse {
    private UUID storyId;
    private List<UUID> readListIds;
}
