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
    @GeneratedValue(generator = "UUID")
    @Column(name = "orderId", updatable = false, nullable = false)
    private UUID orderId;

    @Column(name = "status", length = 250)
    private String status;

    @Column(name = "totalPrice")
    private Float totalPrice;

    @Column(name = "paidDay")
    @Temporal(TemporalType.DATE)
    private Date paidDay;

    @Column(name = "paymentName", length = 100)
    private String paymentName;

}
