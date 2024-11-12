package hcmut.contentCreatorOnline.model.IsAvailableIn;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "IsAvailableIn")
public class IsAvailableIn {
    @Column(name = "tierNumber", nullable = false)
    private Long tierNumber;

    @Column(name = "creatorId", nullable = false)
    private UUID creatorId;

    @Column(name = "creationId", nullable = false)
    private UUID creationId;

    @Column(name = "discountForSaleCreation", precision = 10, scale = 2)
    private BigDecimal discountForSaleCreation;
}
