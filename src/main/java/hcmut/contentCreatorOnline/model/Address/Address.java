package hcmut.contentCreatorOnline.model.Address;

import hcmut.contentCreatorOnline.model.User.UserAccount;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue
    private UUID userId;

    private String country;
    private String city;
    private String street;
    private String state;

    // Quan hệ một-một với CCO_USER
    @OneToOne
    @JoinColumn(name = "userId")
    private UserAccount user;
}
