package hcmut.contentCreatorOnline.model;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "cco_user")
public class CCO_User {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "user_password", nullable = false)
    private String user_password;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "is_admin")
    private boolean is_admin = false;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "commentId", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Comment> comments;

    @OneToMany(mappedBy = "readListId", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<ReadList> readLists;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<IsUsed> user;
}
