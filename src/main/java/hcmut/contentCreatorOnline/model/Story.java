package hcmut.contentCreatorOnline.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

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

    @Column(name = "release_status")
    private Boolean releaseStatus;

    @Column(name = "story_title", nullable = false)
    private String storyTitle;

    @Column(name = "sale_only")
    private Boolean saleOnly;

    @Column(name = "sale_price")
    private Double salePrice;

    @Column(name = "number_of_likes")
    private int numberOfLikes;

    @Column(name = "cover_image_uri")
    private String coverImageUri;

    @Column(name = "story_description", columnDefinition = "TEXT")
    private String storyDescription;

    @Column(name = "tags")
    private String tags;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", nullable = false)
    private Creator creator;

    @OneToMany(mappedBy = "story", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Chapter> chapters;

    @ManyToMany
    @JoinTable(name = "belongs", joinColumns = @JoinColumn(name = "story_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany(mappedBy = "stories")
    private Set<ReadList> readLists = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "membership_plan_id")
    private MembershipPlan membershipPlan;
}
