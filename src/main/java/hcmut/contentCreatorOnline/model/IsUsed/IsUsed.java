package hcmut.contentCreatorOnline.model.IsUsed;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "IsUsed")
public class IsUsed {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "paymentId", updatable = false, nullable = false)
    private UUID paymentId;

    @GeneratedValue(generator = "UUID")
    @Column(name = "userId", updatable = false, nullable = false)
    private UUID userId;

    @Column(name = "accountNumber", length = 50)
    private String accountNumber;
}
