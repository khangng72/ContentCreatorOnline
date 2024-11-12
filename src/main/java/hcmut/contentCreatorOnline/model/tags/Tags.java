package hcmut.contentCreatorOnline.model.tags;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Tags")
public class Tags {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "creationId", updatable = false, nullable = false)
    private UUID creationId;

    @Column(name = "tag", length = 50)
    private String tag;
}
