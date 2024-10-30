package hcmut.contentCreatorOnline.repository.user;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import hcmut.contentCreatorOnline.model.User.UserAccount;

public interface UserRegisterRepo extends JpaRepository<UserAccount, UUID> {
    Optional<UserAccount> findByEmail(String email);
}
