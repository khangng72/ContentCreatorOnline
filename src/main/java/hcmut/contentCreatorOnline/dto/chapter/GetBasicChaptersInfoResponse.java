package hcmut.contentCreatorOnline.dto.chapter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetBasicChaptersInfoResponse {
    private Integer status;
    private List<BasicChapterInfoDTO> result;
}
