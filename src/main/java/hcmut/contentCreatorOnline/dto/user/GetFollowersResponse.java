package hcmut.contentCreatorOnline.dto.user;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetFollowersResponse {
    private Integer status;
    private List<FollowerDTO> result;
}
