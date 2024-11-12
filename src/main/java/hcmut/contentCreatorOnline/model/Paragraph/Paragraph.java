package hcmut.contentCreatorOnline.model.Paragraph;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.util.UUID;

public class Paragraph {
    @Id
    @Column(name = "paragraphNumber", nullable = false)
    private Integer paragraphNumber;

    @Id
    @Column(name = "chapterNumber", nullable = false)
    private Integer chapterNumber;

    @Id
    @Column(name = "creationId", nullable = false)
    private UUID creationId;

    @Column(name = "paragraphContent", length = 250)
    private String paragraphContent;

    @Column(name = "paragraphImageURI", length = 250)
    private String paragraphImageURI;
}
