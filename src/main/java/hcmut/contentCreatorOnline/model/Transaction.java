package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    private UUID id;

    @Column(name = "paymentName")
    private String paymentName;

    @Column(name = "joinDate")
    private Date joinDate;

    @Column(name = "price")
    private Double price;

    @Column(name = "tierNumber")
    private Integer tierNumber;

    @Column(name = "readerId")
    private UUID readerId;
}
