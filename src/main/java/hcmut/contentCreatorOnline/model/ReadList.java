package hcmut.contentCreatorOnline.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigInteger;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Read_List")
public class ReadList {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "readListId", updatable = false, nullable = false)
    private UUID readListId;

    @Column(name = "readListName", length = 250)
    private String readListName;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "upVote")
    private Integer upVote;

    @Column(name = "quantity")
    private BigInteger quantity;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,referencedColumnName = "user_id")
    @JsonBackReference
    private UserAccount user;
}
