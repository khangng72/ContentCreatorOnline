package hcmut.contentCreatorOnline.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ReaderMembershipId implements Serializable {

    private UUID readerId;

    private UUID membershipPlanId;
}
