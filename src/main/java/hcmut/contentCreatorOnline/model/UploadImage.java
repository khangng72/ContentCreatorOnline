package hcmut.contentCreatorOnline.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "upload_image")
public class UploadImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "image_id", columnDefinition = "UUID", nullable = false)
    private UUID imageId;

    @Column(name = "image_uri")
    private String imageUri;

    @Column(name = "uploaded_day", nullable = false)
    private LocalDate uploadedDay = LocalDate.now();

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User userUpload;
}
