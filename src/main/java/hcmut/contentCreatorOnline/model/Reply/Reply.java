package hcmut.contentCreatorOnline.model.Reply;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Reply")
public class Reply {

    @Column(name = "commentId", nullable = false)
    private UUID commentId;

    @Column(name = "replyDate")
    @Temporal(TemporalType.DATE)
    private Date replyDate;

    @Column(name = "parentCommentId")
    private UUID parentCommentId;
}
