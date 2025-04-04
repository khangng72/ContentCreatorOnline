package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "story")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(name = "story_id", nullable = false)
    private UUID storyId;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "release_status")
    private Boolean releaseStatus;

    @Column(name = "story_title", nullable = false)
    private String storyTitle;

    @Column(name = "sale_only")
    private Boolean saleOnly;

    @Column(name = "sale_price")
    private Double salePrice;

    @Column(name = "number_of_likes")
    private Integer numberOfLikes;

    @Column(name = "cover_image_uri")
    private String coverImageUri;

    @Column(name = "story_description", columnDefinition = "TEXT")
    private String storyDescription;

    @Column(name = "tags")
    private String tags;

    @OneToMany(mappedBy = "story", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Chapter> chapters;

    @ManyToMany
    @JoinTable(name = "belongs", joinColumns = @JoinColumn(name = "story_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany(mappedBy = "stories")
    private Set<ReadList> readLists = new HashSet<>();

    @ManyToMany(mappedBy = "produces")
    private Set<Order> orders = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userPost;

    @ManyToMany
    @JoinTable(name = "user_own_story", joinColumns = @JoinColumn(name = "story_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> userOwn = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_like_story", joinColumns = @JoinColumn(name = "story_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> userLike = new HashSet<>();
}
