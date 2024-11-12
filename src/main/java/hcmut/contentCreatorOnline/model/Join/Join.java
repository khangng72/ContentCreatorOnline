package hcmut.contentCreatorOnline.model.Join;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Join")
public class Join {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "readerId", updatable = false, nullable = false)
    private UUID readerId;

    @GeneratedValue(generator = "UUID")
    @Column(name = "creatorId", updatable = false, nullable = false)
    private UUID creatorId;

    @Column(name = "tierNumber")
    private BigInteger tierNumber;

    @Column(name = "joinDate")
    @Temporal(TemporalType.DATE)
    private Date joinDate;
}
