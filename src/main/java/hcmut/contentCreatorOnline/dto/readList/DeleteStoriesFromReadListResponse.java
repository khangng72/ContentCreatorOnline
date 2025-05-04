package hcmut.contentCreatorOnline.dto.readList;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DeleteStoriesFromReadListResponse {
    private UUID read_list_id;
}
