package hcmut.contentCreatorOnline.dto.readList;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateReadListRequest {
    private String readListTitle;
    private String readListDescription;
}
