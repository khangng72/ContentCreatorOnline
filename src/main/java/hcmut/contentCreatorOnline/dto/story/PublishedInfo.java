package hcmut.contentCreatorOnline.dto.story;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PublishedInfo {
    private UUID storyId;
    private Integer published;
    private Integer draft;
}
