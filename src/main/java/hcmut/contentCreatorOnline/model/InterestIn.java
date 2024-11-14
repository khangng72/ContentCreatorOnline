package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "InterestIn")
public class InterestIn {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private UUID id;

    @Column(name = "readerId")
    private UUID readerId;

    @Column(name = "genreId")
    private UUID genreId;
}
