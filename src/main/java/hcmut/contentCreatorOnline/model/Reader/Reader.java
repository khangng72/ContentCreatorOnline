package hcmut.contentCreatorOnline.model.Reader;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Reader")
public class Reader {
    @Id
    @GeneratedValue(generator = "UUID")

    @Column(name = "readerId", updatable = false, nullable = false)
    private UUID readerId;

    @Column(name = "readingTime")
    @Temporal(TemporalType.DATE)
    private Date readingTime;

    @Column(name = "isShowInfo", length = 100)
    private String isShowInfo;
}
