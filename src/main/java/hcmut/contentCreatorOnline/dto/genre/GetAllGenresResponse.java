package hcmut.contentCreatorOnline.dto.genre;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class GetAllGenresResponse {
    private int status;
    private List<GenreResult> result;
}
