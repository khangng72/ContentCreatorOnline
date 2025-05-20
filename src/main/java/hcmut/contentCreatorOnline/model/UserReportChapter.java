package hcmut.contentCreatorOnline.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "user_report_chapter")
public class UserReportChapter {
    @EmbeddedId
    private UserReportChapterId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @MapsId("chapterId")
    @JoinColumn(name = "chapter_id", referencedColumnName = "chapter_id")
    private Chapter chapter;

    @Column(name = "reason")
    private String reason;

    @Column(name = "state")
    private String state;

    @Column(name = "resolve_date")
    private Date ResolveDate;

    @Column(name = "report_date")
    private Date ReportDate;
}
