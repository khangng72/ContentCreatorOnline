package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "chapter")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    private UUID chapterId;

    private Integer chapterNumber;

    private String chapterTitle;

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
