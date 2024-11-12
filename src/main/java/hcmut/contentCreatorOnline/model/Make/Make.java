package hcmut.contentCreatorOnline.model.Make;

import java.math.BigInteger;
import java.util.UUID;

import hcmut.contentCreatorOnline.model.Reader.Reader;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Getter
@Setter
@Entity
@Table(name = "Make")
public class Make {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "orderId", updatable = false, nullable = false)
    private UUID orderId;

    @Column(name = "readerId", nullable = false)
    private BigInteger readerId;
}
