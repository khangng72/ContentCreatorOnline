package hcmut.contentCreatorOnline.model.Genre;


import jakarta.persistence.*;


import java.util.UUID;

public class Genre {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "genreId", updatable = false, nullable = false)
    private UUID genreId;

    @Column(name = "genreName", length = 250)
    private String genreName;
}
