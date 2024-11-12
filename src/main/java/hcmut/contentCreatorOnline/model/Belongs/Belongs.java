package hcmut.contentCreatorOnline.model.Belongs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Belongs")
public class Belongs {

    @Column(name = "genreId", nullable = false)
    private UUID genreId;


    @Column(name = "creationId", nullable = false)
    private UUID creationId;
}
