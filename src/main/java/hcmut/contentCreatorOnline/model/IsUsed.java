package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "IsUsed")
public class IsUsed {

    @EmbeddedId
    PayUsedIdKey id;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    CCO_User user;

    @ManyToOne
    @MapsId("payment_id")
    @JoinColumn(name = "payment_id")
    Payment payment;

    @Column(name = "accountNumber")
    private String accountNumber;


}
