package hcmut.contentCreatorOnline.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import hcmut.contentCreatorOnline.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}
