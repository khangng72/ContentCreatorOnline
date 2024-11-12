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
    @GeneratedValue
    private UUID orderId;

    private UUID creationId;

    // Quan hệ nhiều-một với ORDER
    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Order order;

    // Quan hệ nhiều-một với CREATION
    @ManyToOne
    @JoinColumn(name = "creationId", referencedColumnName = "creationId")
    private Creation creation;
}
