package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "IsAvailableIn")
public class Is_Available_In {
    @EmbeddedId
    Is_Available_In_key id;

    @ManyToOne
    @MapsId("creation_id")
    @JoinColumn(name = "creation_id", referencedColumnName = "creationId")
    Creation creation;

    @ManyToOne
    @MapsId("tierNumber")
    @JoinColumn(name = "tierNumber", referencedColumnName = "tierNumber")
    Join_Tier joinTier;

    @Column(name = "discountForSaleCreation")
    private Double discountForSaleCreation;
}
