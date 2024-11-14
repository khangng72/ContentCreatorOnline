package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "paymentId", updatable = false, nullable = false)
    private UUID paymentId;

    @Column(name = "paymentName", length = 100)
    private String paymentName;

    @OneToMany(mappedBy = "payment")
    private Set<IsUsed> payment;
}
