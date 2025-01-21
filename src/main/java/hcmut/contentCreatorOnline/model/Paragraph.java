package hcmut.contentCreatorOnline.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "paragraph")
public class Paragraph {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    private UUID paragraphId;

    @Column(name = "paragraph_number", nullable = false)
    private Integer paragraphNumber;

    @Column(name = "paragraph_content", columnDefinition = "TEXT")
    private String paragraphContent;

    @Column(name = "paragraph_image_uri")
    private String paragraphImageUri;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id", nullable = false)
    private Chapter chapter;
}
