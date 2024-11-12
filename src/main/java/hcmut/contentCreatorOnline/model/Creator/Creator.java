package hcmut.contentCreatorOnline.model.Creator;

import hcmut.contentCreatorOnline.model.Reader.Reader;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="Creator")
public class Creator {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "creatorId", updatable = false, nullable = false)
    private UUID creatorId;

    @Column(name = "numberOfContents")
    private BigInteger numberOfContents;

    @Column(name = "numberOfFollowers")
    private BigInteger numberOfFollowers;
}
