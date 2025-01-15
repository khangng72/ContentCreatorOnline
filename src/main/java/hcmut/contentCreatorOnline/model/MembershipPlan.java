package hcmut.contentCreatorOnline.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "membership_plan")
public class MembershipPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID membership_plan_id;

    private String title;

    private String membership_plan_description;

    private Float price;

    private String cover_uri;

    private Boolean is_charged;

    private String status;

    @OneToOne
    @JoinColumn(name = "lower_membership_plan_id")
    private MembershipPlan lowerMembershipPlan;

    @OneToMany(mappedBy = "membershipPlan")
    private List<Story> stories;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Creator creator;

    @OneToMany(mappedBy = "membershipPlan", cascade = CascadeType.ALL)
    private List<ReaderJoinMembership> readers;
}
