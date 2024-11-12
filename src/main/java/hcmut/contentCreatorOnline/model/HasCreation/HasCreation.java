package hcmut.contentCreatorOnline.model.HasCreation;

import hcmut.contentCreatorOnline.model.Creation.Creation;
import hcmut.contentCreatorOnline.model.Order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "HasCreation")
public class HasCreation {
    @Id
    @GeneratedValue(generator = "UUID")

    @Column(name = "orderId", updatable = false, nullable = false)
    private UUID orderId;

    @GeneratedValue(generator = "UUID")
    @Column(name = "creationId", updatable = false, nullable = false)
    private UUID creationId;
}
