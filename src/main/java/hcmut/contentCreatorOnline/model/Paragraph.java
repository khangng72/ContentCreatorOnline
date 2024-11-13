package hcmut.contentCreatorOnline.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Paragraph")
public class Paragraph {
    @Id
    @Column(name = "paragraphNumber", nullable = false)
    private Integer paragraphNumber;

    @Column(name = "paragraphContent", length = 250)
    private String paragraphContent;

    @Column(name = "paragraphImageURI", length = 250)
    private String paragraphImageURI;

    @ManyToOne
    @JoinColumn(name = "Chapter", nullable = false, referencedColumnName = "chapterNumber")
    @JsonBackReference
    private Chapter chapter;
}
