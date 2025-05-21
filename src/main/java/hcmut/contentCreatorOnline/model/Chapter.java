package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "chapter")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Chapter {
    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<Comment> comments;

    @Id
    @Column(name = "chapter_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    private UUID chapterId;

    private Integer chapterNumber;

    @Column(name = "number_of_comment")
    private Integer numberOfComment;

    private String chapterTitle;

    @Column(name = "number_of_likes")
    private Integer numberOfLikes = 0;

    @Builder.Default
    @Column(name = "is_published")
    private Boolean isPublished = false;

    @Column(name = "chapter_description", columnDefinition = "TEXT")
    private String chapterDescription;

    @Builder.Default
    @Column(name = "created_time")
    private LocalDateTime createdTime = LocalDateTime.now();

    @Column(name = "isBanned")
    @Builder.Default
    private Boolean isBanned = false;


    @Builder.Default
    @Column(name = "updated_time")
    private LocalDateTime updatedTime = LocalDateTime.now();


    @Column(name = "chapter_content", columnDefinition = "TEXT")
    private String chapterContent;

    private String chapterImageUri;

    @ManyToOne
    @JoinColumn(name = "story_id", nullable = false)
    private Story story;

    @Builder.Default
    @ManyToMany
    @JoinTable(name = "user_like_chapter", joinColumns = @JoinColumn(name = "chapter_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> usersLikeChapter = new ArrayList<>();

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<UserReportChapter> userReportChapters = new HashSet<>();
}
