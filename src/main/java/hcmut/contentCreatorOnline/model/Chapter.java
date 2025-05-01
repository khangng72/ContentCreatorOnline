package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "chapter")
public class Chapter {
    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<Comment> comments;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    private UUID chapterId;

    private Integer chapterNumber;

    @Column(name = "number_of_comment")
    private Integer numberOfComment;

    private String chapterTitle;

    @Column(name = "number_of_likes")
    private Integer numberOfLikes = 0;

    @Column(name = "is_published")
    private Boolean isPublished = true;

    @Column(name = "chapter_description", columnDefinition = "TEXT")
    private String chapterDescription;

    @Column(name = "created_time")
    private LocalDateTime createdTime = LocalDateTime.now();

    @Column(name = "chapter_content", columnDefinition = "TEXT")
    private String chapterContent;

    private String chapterImageUri;
    
    @ManyToOne
    @JoinColumn(name = "story_id", nullable = false)
    private Story story;

    @ManyToMany
    @JoinTable(name = "user_like_chapter", joinColumns = @JoinColumn(name = "chapter_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> userChapter = new HashSet<>();

}
