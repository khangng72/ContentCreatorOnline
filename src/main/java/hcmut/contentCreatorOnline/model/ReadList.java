package hcmut.contentCreatorOnline.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "read_list")
public class ReadList {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "read_list_id", updatable = false, nullable = false)
    private UUID readListId;

    @Column(name = "read_list_title", nullable = false)
    private String readListTitle;

    @Column(name = "read_list_description", length = 1000)
    private String description;

    private Integer numberOfLikes;

    private Integer quantity;

    private String readListCover;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "contains", joinColumns = @JoinColumn(name = "read_list_id"), inverseJoinColumns = @JoinColumn(name = "story_id"))
    private Set<Story> stories = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "has_genre", joinColumns = @JoinColumn(name = "read_list_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();
}
