package hcmut.contentCreatorOnline.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "Join_Tier")
public class Join_Tier {
    @Id
    @Column(name = "tierNumber", nullable = false)
    private Long tierNumber;

    @Column(name = "tierTitle")
    private String tierTitle;

    @Column(name = "tierContent")
    private String tierContent;

    @Column(name = "tierImageURI")
    private String tierImageURI;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "isCharged")
    private Boolean isCharged;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "creatorId")
    private UUID creatorId;
//
//    @OneToMany(mappedBy = "joinTier", cascade = CascadeType.ALL)
//    private Set<Is_Available_In> tierDiscount;
}
