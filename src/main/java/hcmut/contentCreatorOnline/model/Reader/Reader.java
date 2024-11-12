package hcmut.contentCreatorOnline.model.Reader;

import hcmut.contentCreatorOnline.model.Creator.Creator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Reader")
public class Reader {
    @Id
    @GeneratedValue
    private UUID readerId;

    private Date readingTime;
    private String isShowInfo;

    // Quan hệ nhiều-nhiều với CREATOR (qua JOIN_TABLE)
    @ManyToMany
    @JoinTable(
            name = "JOIN_TABLE",
            joinColumns = @JoinColumn(name = "readerId"),
            inverseJoinColumns = @JoinColumn(name = "creatorId")
    )
    private List<Creator> creators;
}
