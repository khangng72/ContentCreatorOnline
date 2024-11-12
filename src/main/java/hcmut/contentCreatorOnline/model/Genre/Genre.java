package hcmut.contentCreatorOnline.model.Genre;

import hcmut.contentCreatorOnline.model.Creation.Creation;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

public class Genre {
    @Id
    @GeneratedValue
    private UUID genreId;

    private String genreName;

    // Quan hệ nhiều-nhiều với CREATION (qua bảng BELONGS)
    @ManyToMany
    @JoinTable(
            name = "BELONGS",
            joinColumns = @JoinColumn(name = "genreId"),
            inverseJoinColumns = @JoinColumn(name = "creationId")
    )
    private List<Creation> creations;
}
