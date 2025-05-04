package hcmut.contentCreatorOnline.dto.readList;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ReadListDTO {
    private UUID read_list_id;
    private String read_list_title;
    private String read_list_description;
    private Integer number_of_stories;
    private UUID user_id;
}
