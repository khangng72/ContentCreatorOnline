package hcmut.contentCreatorOnline.model.User;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ma_user")
public class UserAccount {

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
}
