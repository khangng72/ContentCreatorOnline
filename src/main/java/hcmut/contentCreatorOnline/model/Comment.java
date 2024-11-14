package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Comments")
public class Comment {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "commentId", updatable = false, nullable = false)
    private UUID commentId;

    @Column(name = "commentDate")
    private Date commentDate;

    @Column(name = "content", length = 250)
    private String content;

    @Column(name = "numberOfLikes")
    private Long numberOfLikes;

    @Column(name = "numberOfDislikes")
    private Long numberOfDislikes;

    @Column(name = "isPinned")
    private Boolean isPinned;

    @Column(name = "userId")
    private UUID userId;

    @Column(name = "childCommentId")
    private UUID childCommentId;

    @Column(name = "creationId")
    private UUID creationId;

}
