package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Chapter")
public class Chapter {
    @Id
    @Column(name = "chapterNumber", nullable = false)
    private Integer chapterNumber;

    @Column(name = "chapterName", length = 250)
    private String chapterName;

    @Column(name = "chapterDescription", length = 4000)
    private String chapterDescription;

    @Column(name = "chapterImageURI", length = 250)
    private String chapterImageURI;

    @Column(name = "creationId")
    private UUID creationId;



}
