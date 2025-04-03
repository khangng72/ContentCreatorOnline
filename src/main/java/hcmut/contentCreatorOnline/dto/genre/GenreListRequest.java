package hcmut.contentCreatorOnline.dto.genre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreListRequest {
    private List<GenreResult> genreList;
}
