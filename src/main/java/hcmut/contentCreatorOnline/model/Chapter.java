package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "chapter")
public class Chapter {
    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<Comment> comments;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    private UUID chapterId;

    private Integer chapterNumber;

    private String chapterTitle;

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

}
