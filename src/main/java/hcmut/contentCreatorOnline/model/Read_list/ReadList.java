package hcmut.contentCreatorOnline.model.Read_list;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "ReadList")
public class ReadList {
    @Id
    @GeneratedValue(generator = "UUID")

    @Column(name = "readListId", updatable = false, nullable = false)
    private UUID readListId;

    @Column(name = "readListName", length = 250)
    private String readListName;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "creationName", length = 250)
    private String creationName;

    @Column(name = "saleOnly")
    private Boolean saleOnly;

    @Column(name = "salePrice", precision = 10, scale = 2)
    private BigDecimal salePrice;

    @Column(name = "numberOfLikes")
    private Long numberOfLikes;

    @Column(name = "numberOdDislikes")
    private Long numberOfDislikes;

    @Column(name = "coverImageURI", length = 250)
    private String coverImageURI;
}
