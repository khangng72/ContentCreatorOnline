package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Contains")
public class Contains {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private UUID id;

    @Column(name = "readListId")
    private UUID readListId;

    @Column(name = "creationId")
    private UUID creationId;
}
