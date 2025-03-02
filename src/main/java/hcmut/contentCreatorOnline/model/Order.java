package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id", columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID orderId;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_contain", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "story_id"))
    private Set<Story> produces = new HashSet<>();
}
