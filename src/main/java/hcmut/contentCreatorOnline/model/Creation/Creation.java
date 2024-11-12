package hcmut.contentCreatorOnline.model.Creation;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Creation")
public class Creation {
    @Id
    @Column(name = "creationId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID creationId;

    @Column(name = "releaseDate")
    private Date releaseDate;

    @Column(name = "releaseStatus")
    private boolean releaseStatus;

    @Column(name = "creationName")
    private String creationName;

    @Column(name = "saleOnly")
    private boolean saleOnly;

    @Column(name = "salePrice")
    private long salePrice;

    @Column(name = "numberOfLikes")
    private long numberOfLikes;

    @Column(name = "numberOfDislikes")
    private long numberOfDislikes;

    @Column(name = "coverImageURI")
    private String coverImageURI;

    @Column(name = "description")
    private String description;

    @Column(name = "tag")
    private String tag;

    public Creation() {
    }

    public Creation(UUID creationId, Date releaseDate, boolean releaseStatus, String creationName, boolean saleOnly, long salePrice, long numberOfLikes, long numberOfDislikes, String coverImageURI, String description, String tag) {
        this.creationId = creationId;
        this.releaseDate = releaseDate;
        this.releaseStatus = releaseStatus;
        this.creationName = creationName;
        this.saleOnly = saleOnly;
        this.salePrice = salePrice;
        this.numberOfLikes = numberOfLikes;
        this.numberOfDislikes = numberOfDislikes;
        this.coverImageURI = coverImageURI;
        this.description = description;
        this.tag = tag;
    }
}
