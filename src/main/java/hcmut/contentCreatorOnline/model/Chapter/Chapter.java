package hcmut.contentCreatorOnline.model.Chapter;

import hcmut.contentCreatorOnline.model.Creation.Creation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Chapter")
public class Chapter {
    @Id
    private int chapterNumber;
    @Id
    private UUID creationId;

    private String chapterName;
    private String chapterDescription;
    private String chapterImageURI;

    // Quan hệ nhiều-một với CREATION
    @ManyToOne
    @JoinColumn(name = "creationId", insertable = false, updatable = false)
    private Creation creation;
}
