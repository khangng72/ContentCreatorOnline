package hcmut.contentCreatorOnline.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false, referencedColumnName = "user_id")
    @JsonBackReference
    private UserAccount user;

    @ManyToOne
    @JoinColumn(name = "creationId",nullable = false, referencedColumnName = "creationId")
    @JsonBackReference
    private Creation creation;

}
