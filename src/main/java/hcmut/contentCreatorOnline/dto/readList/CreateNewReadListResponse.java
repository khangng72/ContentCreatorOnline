package hcmut.contentCreatorOnline.dto.readList;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateNewReadListResponse {
    private Integer status;
    private ReadListDTO result;
}
