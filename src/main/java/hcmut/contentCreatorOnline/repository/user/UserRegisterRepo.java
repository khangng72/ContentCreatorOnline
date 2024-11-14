package hcmut.contentCreatorOnline.repository.user;

import java.util.Optional;
import java.util.UUID;

import hcmut.contentCreatorOnline.model.CCO_User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegisterRepo extends JpaRepository<CCO_User, UUID> {
    Optional<CCO_User> findByEmail(String email);
}
