package hcmut.contentCreatorOnline.model.Comment;

import hcmut.contentCreatorOnline.model.Creation.Creation;
import hcmut.contentCreatorOnline.model.User.UserAccount;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name ="Comment")
public class Comment {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "commentId", updatable = false, nullable = false)
    private UUID commentId;

    @Column(name = "commentDate")
    @Temporal(TemporalType.DATE)
    private Date commentDate;

    @Column(name = "content", length = 250)
    private String content;

    @Column(name = "numberOfLikes")
    private Long numberOfLikes;

    @Column(name = "numberOfDislikes")
    private Long numberOfDislikes;

    @Column(name = "isPinned")
    private Boolean isPinned;

    @Column(name = "userId", updatable = false, nullable = false)
    private UUID userId;

    @Column(name = "creationId", updatable = false, nullable = false)
    private UUID creationId;


}
