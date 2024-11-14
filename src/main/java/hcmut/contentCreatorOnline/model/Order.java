package hcmut.contentCreatorOnline.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
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
    private Date paidDay;

    @Column(name = "paymentName", length = 100)
    private String paymentName;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private Set<HasCreation> orders;

    @ManyToOne
    @JoinColumn(name = "readerId", referencedColumnName = "readerId")
    @JsonBackReference
    private Reader reader;
}
