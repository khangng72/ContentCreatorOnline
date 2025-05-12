package hcmut.contentCreatorOnline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cco_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column
    private String avatarUrl;

    @Column(name = "background_url")
    private String backgroundUrl;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "is_admin")
    @Builder.Default
    private boolean isAdmin = false;

    @Column(name = "is_active")
    @Builder.Default
    private boolean isActive = true;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "birthday")
    private LocalDate birthday;

    private LocalDate joinDate = LocalDate.now();

    @Column(columnDefinition = "TEXT")
    private String introduction;

    @OneToMany(mappedBy = "userCreated", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ReadList> readLists;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Order> orders;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Set<Genre> genreSet = new HashSet<>();

    @OneToMany(mappedBy = "userPost")
    private Set<Story> storyPost = new HashSet<>();

    @ManyToMany(mappedBy = "userOwn")
    private Set<Story> ownStory = new HashSet<>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comment> comments;

    @OneToMany(mappedBy = "userUpload", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<UploadImage> uploadImage = new HashSet<>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<UserStoryRating> userStoryRatings = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_followers",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id")
    )
    private Set<User> followers = new HashSet<>();

    @ManyToMany(mappedBy = "followers", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<User> following = new HashSet<>();

    @ManyToMany(mappedBy = "usersLikeChapter")
    private List<Chapter> likedChapters = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<UserReadStory> userReadStory = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "user_likes_comment",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id")
    )
    private Set<Comment> likedComments = new HashSet<>();

    // Reading Preference
    @Column(name = "default_reading_text_size")
    private Double defaultReadingTextSize;

    @Column(name = "default_reading_word_spacing")
    private Double defaultReadingWordSpacing;

    @Column(name = "default_reading_line_height")
    private Double defaultReadingLineHeight;

    // Writing Preference
    @Column(name = "default_writing_text_size")
    private Double defaultWritingTextSize;

    @Column(name = "default_writing_word_spacing")
    private Double defaultWritingWordSpacing;

    @Column(name = "default_writing_line_height")
    private Double defaultWritingLineHeight;

}
