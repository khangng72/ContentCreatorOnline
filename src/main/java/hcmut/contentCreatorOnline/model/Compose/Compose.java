package hcmut.contentCreatorOnline.model.Compose;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Compose")
public class Compose {

    @Column(name = "creationId", nullable = false)
    private UUID creationId;


    @Column(name = "creatorId", nullable = false)
    private UUID creatorId;
}
