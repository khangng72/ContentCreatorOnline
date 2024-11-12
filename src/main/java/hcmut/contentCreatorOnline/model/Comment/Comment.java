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
    @GeneratedValue
    private UUID commentId;

    private Date commenDate;
    private String content;
    private Long numberOfLikes;
    private Long numberOfDislikes;
    private boolean isPinned;

//    private String userId;
//    private String creationId;
// Quan hệ nhiều-một với CCO_USER
@ManyToOne
@JoinColumn(name = "userId", referencedColumnName = "userId")
    private UserAccount user;

    // Quan hệ nhiều-một với CREATION
    @ManyToOne
    @JoinColumn(name = "creationId", referencedColumnName = "creationId")
    private Creation creation;


}
