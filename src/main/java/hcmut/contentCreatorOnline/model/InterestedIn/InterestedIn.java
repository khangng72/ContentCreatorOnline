package hcmut.contentCreatorOnline.model.InterestedIn;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "TnterestedIn")
public class InterestedIn {

    @Column(name = "readerId", nullable = false)
    private UUID readerId;


    @Column(name = "genreId", nullable = false)
    private UUID genreId;
}
