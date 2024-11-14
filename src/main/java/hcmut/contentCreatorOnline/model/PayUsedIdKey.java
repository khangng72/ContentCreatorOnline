package hcmut.contentCreatorOnline.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Embeddable
public class PayUsedIdKey implements Serializable {
    @Column(name = "userId")
    UUID user_id;

    @Column(name = "paymentId")
    UUID payment_id;
}
