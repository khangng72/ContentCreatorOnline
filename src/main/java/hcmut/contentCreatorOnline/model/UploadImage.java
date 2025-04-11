package hcmut.contentCreatorOnline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "upload_image")
public class UploadImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "image_id", columnDefinition = "UUID", nullable = false)
    private UUID imageId;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "created_day", nullable = false)
    private LocalDate createdDay = LocalDate.now();

    @Column(name = "status")
    private Boolean status = false;

    @Column(name = "updated_day", nullable = false)
    private LocalDate updatedDay;

    @ManyToOne
    @JoinColumn(name = "user_upload", nullable = false)
    @JsonIgnore
    private User userUpload;
}
