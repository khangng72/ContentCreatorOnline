package hcmut.contentCreatorOnline.model.Order;

import hcmut.contentCreatorOnline.model.HasCreation.HasCreation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    private UUID orderId;

    private String status;
    private Float totalPrice;
    private Date paidDay;
    private String paymentName;

    // Quan hệ một-nhiều với HAS_CREATION
    @OneToMany(mappedBy = "order")
    private List<HasCreation> creations;

}
