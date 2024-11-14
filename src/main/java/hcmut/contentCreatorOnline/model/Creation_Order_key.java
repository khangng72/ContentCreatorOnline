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
public class Creation_Order_key implements Serializable {

    @Column(name = "creation_id")
    UUID creation_id;

    @Column(name = "order_id")
    UUID order_id;
}
