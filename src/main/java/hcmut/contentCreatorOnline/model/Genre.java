package hcmut.contentCreatorOnline.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Genre")
public class Genre {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "genreId", updatable = false, nullable = false)
    private UUID genreId;

    @Column(name = "genreName", length = 250)
    private String genreName;

    @ManyToMany
    @JoinTable(
            name = "has_genre",
            joinColumns = @JoinColumn(name = "genreId"),
            inverseJoinColumns = @JoinColumn(name = "readlistid")
    )
    @JsonManagedReference
    private Set<ReadList> readLists;

    @ManyToMany
    @JoinTable(
            name = "belongs",
            joinColumns = @JoinColumn(name = "genreId"),
            inverseJoinColumns = @JoinColumn(name = "creationId")
    )
    @JsonManagedReference
    private Set<Creation> creations;

    @ManyToMany
    @JoinTable(
            name = "interested_in",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "reader_id")
    )
    @JsonManagedReference
    private Set<Reader> readers;
}
