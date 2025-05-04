package hcmut.contentCreatorOnline.dto.readList;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateNewReadListRequest {
    private String readListTitle;
    private String readListDescription;
}
