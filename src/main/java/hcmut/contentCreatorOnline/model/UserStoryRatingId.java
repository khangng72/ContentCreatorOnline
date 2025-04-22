package hcmut.contentCreatorOnline.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Embeddable
public class UserStoryRatingId implements Serializable {

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "story_id")
    private UUID storyId;

    public UserStoryRatingId(UUID userId, UUID storyId) {
        this.userId = userId;
        this.storyId = storyId;
    }

    public UserStoryRatingId() {
    }

    // Getters, Setters, Constructors, hashCode, equals
}

