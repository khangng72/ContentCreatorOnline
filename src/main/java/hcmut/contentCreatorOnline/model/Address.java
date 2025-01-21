package hcmut.contentCreatorOnline.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_address")
public class Address {
    @Id
    @Column(name = "address_id", columnDefinition = "UUID", nullable = false)
    private UUID addressId;

    @Column(name = "street")
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "user_state")
    private String userState;

    @Column(name = "postal_code", length = 20)
    private String postalCode;

    @Column(name = "country", nullable = false)
    private String country;
}
