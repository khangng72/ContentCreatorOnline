package hcmut.contentCreatorOnline.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "comment_id", nullable = false)
    private UUID commentId;

    private LocalDate commentDate;

    private String commentContent;

    private Integer numberOfLikes;

    private Boolean isPinned;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Creator creator;

    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story;

    private Boolean isDeleted;
}
