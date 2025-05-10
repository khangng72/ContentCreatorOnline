package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "user_read_story")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserReadStory {
    @EmbeddedId
    private UserReadStoryId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("storyId")
    @JoinColumn(name = "story_id")
    private Story story;

    @Column(name = "chapter_id")
    private UUID chapterId;
}
