package hcmut.contentCreatorOnline.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class UserLikeStoryId implements Serializable {
    private UUID userId;
    private UUID storyId;

    public UserLikeStoryId() {}

    public UserLikeStoryId(UUID userId, UUID storyId) {
        this.userId = userId;
        this.storyId = storyId;
    }

    // equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserLikeStoryId)) return false;
        UserLikeStoryId that = (UserLikeStoryId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(storyId, that.storyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, storyId);
    }
}
