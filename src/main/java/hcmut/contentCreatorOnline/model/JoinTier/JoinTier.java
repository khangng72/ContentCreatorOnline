package hcmut.contentCreatorOnline.model.JoinTier;

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
@Table(name = "JoinTier")
public class JoinTier {
    @Column(name = "tierNumber", nullable = false)
    private Long tierNumber;


    @Column(name = "creatorId", nullable = false)
    private UUID creatorId;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "isCharged")
    private Boolean isCharged;
}
