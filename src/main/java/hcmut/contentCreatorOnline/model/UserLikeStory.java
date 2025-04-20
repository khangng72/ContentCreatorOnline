package hcmut.contentCreatorOnline.model;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "user_like_story")
@IdClass(UserLikeStoryId.class)
public class UserLikeStory {

    @Id
    @Column(name = "user_id")
    private UUID userId;

    @Id
    @Column(name = "story_id")
    private UUID storyId;

    @Column(name = "rating")
    private Integer rating;

    // Quan hệ nếu cần (nếu bạn muốn fetch thông tin user/story từ entity)
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "story_id", insertable = false, updatable = false)
    private Story story;

    // Constructors
    public UserLikeStory() {}

    public UserLikeStory(UUID userId, UUID storyId, Integer rating) {
        this.userId = userId;
        this.storyId = storyId;
        this.rating = rating;
    }

    // Getters/Setters
}

