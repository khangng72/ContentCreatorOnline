package hcmut.contentCreatorOnline.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
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

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
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

    @ManyToMany(mappedBy =  "userOwn")
    private Set<Story> ownStory = new HashSet<>();

    @ManyToMany(mappedBy =  "userLike")
    private Set<Story> likeStory = new HashSet<>();
}
