package hcmut.contentCreatorOnline.repository.creation;

import hcmut.contentCreatorOnline.model.Creation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;


public interface CreationRepository extends JpaRepository<Creation, UUID> {
}
