package hcmut.contentCreatorOnline.dto.readList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReadList_ListResponse {
    private Integer status;
    private List<ReadListDTO> result;
}
