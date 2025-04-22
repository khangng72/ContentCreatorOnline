package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_story_rating")
public class UserStoryRating {

    @EmbeddedId
    private UserStoryRatingId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @MapsId("storyId")
    @JoinColumn(name = "story_id", referencedColumnName = "story_id")
    private Story story;

    @Column(name = "rating", nullable = false)
    private Double rating;

    // Getters, Setters, Constructors
}

