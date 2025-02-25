package hcmut.contentCreatorOnline.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genreId;

    private String genreName;

    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
    private Set<Story> stories = new HashSet<>();

    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
    private Set<ReadList> readLists = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "interested_in", joinColumns = @JoinColumn(name = "genre_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();
}
