package hcmut.contentCreatorOnline.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RatingDTO {

    private UUID userId;
    private UUID storyId;
    private Double rating;

    // Getters, Setters, Constructors
}

