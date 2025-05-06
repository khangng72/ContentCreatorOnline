package hcmut.contentCreatorOnline.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingDTO {

    private UUID userId;
    private UUID storyId;
    private Double rating;
}

