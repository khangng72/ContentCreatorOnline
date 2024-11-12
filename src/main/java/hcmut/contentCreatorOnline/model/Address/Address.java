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
    @GeneratedValue(generator = "UUID")
    @Column(name = "userId", updatable = false, nullable = false)
    private UUID userId;

    @Column(name = "country", length = 250)
    private String country;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "street", length = 100)
    private String street;

    @Column(name = "state")
    private String state;
}
