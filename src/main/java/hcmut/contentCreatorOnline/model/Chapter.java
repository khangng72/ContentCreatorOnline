package hcmut.contentCreatorOnline.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "creationId", nullable = false, referencedColumnName = "creationId")
    @JsonBackReference
    private Creation creation;

    @OneToMany(mappedBy = "paragraphNumber", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Paragraph> paragraphs;
}
