package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "IsAvailableIn")
public class IsAvailableIn {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private UUID id;

    @Column(name = "tierNumber")
    private Integer tierNumber;

    @Column(name = "creationId")
    private UUID creationId;

    @Column(name = "discountForSaleCreation")
    private Double discountForSaleCreation;
}
