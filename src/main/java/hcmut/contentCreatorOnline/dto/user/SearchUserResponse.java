package hcmut.contentCreatorOnline.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SearchUserResponse {
    private Integer status;
    private List<UserResponseDTO> result;
}
