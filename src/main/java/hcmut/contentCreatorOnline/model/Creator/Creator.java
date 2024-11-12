package hcmut.contentCreatorOnline.model.Creator;

import hcmut.contentCreatorOnline.model.Reader.Reader;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="Creator")
public class Creator {
    @Id
    @GeneratedValue
    private UUID creatorId;

    private Long numberOfContents;
    private Long numberOfFollowers;

    // Quan hệ nhiều-nhiều với READER (qua JOIN_TABLE)
    @ManyToMany(mappedBy = "creators")
    private List<Reader> readers;
}
