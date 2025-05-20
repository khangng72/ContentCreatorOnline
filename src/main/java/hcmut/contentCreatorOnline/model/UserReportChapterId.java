package hcmut.contentCreatorOnline.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Embeddable
public class UserReportChapterId implements Serializable {

    @Column(name = "user_id")
    private UUID UserId;

    @Column(name = "chapter_id")
    private UUID ChapterId;

    public UserReportChapterId(UUID userId, UUID chapterId) {
        this.UserId = userId;
        this.ChapterId = chapterId;
    }

    public UserReportChapterId() {
    }

    // Getters, Setters, Constructors, hashCode, equals
}