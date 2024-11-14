package hcmut.contentCreatorOnline.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Creation")
public class Creation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "creationId", nullable = false)
    private Long creationId;

    @Column(name = "creationName", length = 50, nullable = false)
    private String creationName;

    @Column(name = "releaseDate")
    private Date releaseDate;

    @Column(name = "releaseStatus")
    private Boolean releaseStatus;

    @Column(name = "saleOnly")
    private Boolean saleOnly;

    @Column(name = "salePrice")
    private Double salePrice;

    @Column(name = "numberOfLikes")
    private BigInteger numberOfLikes;

    @Column(name = "numberOfDislikes")
    private BigInteger numberOfDislikes;

    @Column(name = "coverImageURI", length = 250)
    private String coverImageURI;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "tags")
    private String Tags;

    @Column(name = "creatorId")
    private UUID creatorId;
}
