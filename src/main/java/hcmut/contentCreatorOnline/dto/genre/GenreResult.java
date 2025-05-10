package hcmut.contentCreatorOnline.dto.genre;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GenreResult {
    private Integer genreId;
    private String genreName;
}