package hcmut.contentCreatorOnline.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Embeddable
public class Is_Available_In_key implements Serializable {
    @Column(name = "creation_id")
    UUID creation_id;

    @Column(name = "tierNumber")
    Integer tier_Number;
}
