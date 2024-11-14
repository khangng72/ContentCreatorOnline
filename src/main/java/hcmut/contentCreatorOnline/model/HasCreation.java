package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "HasCreation")
public class HasCreation {
    @EmbeddedId
    Creation_Order_key id;

    @ManyToOne
    @MapsId("creation_id")
    @JoinColumn(name = "creation_Id")
    Creation creation;

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_Id")
    Order orders;

    private Double price;
}
