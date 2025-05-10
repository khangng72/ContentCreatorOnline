package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Comment {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "comment_id", nullable = false)
    private UUID commentId;

    @Builder.Default
    private LocalDateTime createdTime = LocalDateTime.now();

    private String commentContent;

    @Builder.Default
    private Integer numberOfLikes = 0;

    @Builder.Default
    private Boolean isPinned = false;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> replies;

    private Boolean isDeleted;

    @ManyToMany(mappedBy = "likedComments")
    private Set<User> likedByUsers = new HashSet<>();

}
