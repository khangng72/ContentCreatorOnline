package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Belongs")
public class Belongs {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private UUID id;

    @Column(name = "genreId")
    private UUID genreId;

    @Column(name = "creationId")
    private UUID creationId;
}
