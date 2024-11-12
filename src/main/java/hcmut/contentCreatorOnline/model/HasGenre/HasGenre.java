package hcmut.contentCreatorOnline.model.HasGenre;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "HasGenre")
public class HasGenre {

    @Column(name = "genreId", nullable = false)
    private UUID genreId;


    @Column(name = "readListId", nullable = false)
    private UUID readListId;
}
