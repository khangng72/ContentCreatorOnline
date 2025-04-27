package hcmut.contentCreatorOnline.dto.user;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetFollowingResponse {
    private Integer status;
    private List<FollowingDTO> result;
}
