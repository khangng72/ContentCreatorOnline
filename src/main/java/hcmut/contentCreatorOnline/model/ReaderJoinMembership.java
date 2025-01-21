package hcmut.contentCreatorOnline.model;

import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;

/* Reader joins Membership */
@Entity
@Data
public class ReaderJoinMembership {
    @EmbeddedId
    private ReaderMembershipId id;

    @ManyToOne
    @MapsId("readerId")
    @JoinColumn(name = "reader_id")
    private Reader readers;

    @ManyToOne
    @MapsId("membershipPlanId")
    @JoinColumn(name = "membership_plan_id")
    private MembershipPlan membershipPlan;

    private LocalDate joinDate;

    private LocalDate expireDate;
}
