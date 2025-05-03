package hcmut.contentCreatorOnline.repository;

import hcmut.contentCreatorOnline.dto.user.FollowerDTO;
import hcmut.contentCreatorOnline.dto.user.FollowingDTO;
import hcmut.contentCreatorOnline.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);

    @Query("SELECT new hcmut.contentCreatorOnline.dto.user.FollowerDTO(u.id, u.firstName, u.lastName, u.avatarUrl) FROM User u JOIN u.following f WHERE f.id = :userId")
    Page<FollowerDTO> findFollowersById(@Param("userId") UUID id, Pageable pageable);

    @Query("SELECT new hcmut.contentCreatorOnline.dto.user.FollowingDTO(u.id, u.firstName, u.lastName, u.avatarUrl) FROM User u JOIN u.followers f WHERE f.id = :userId")
    Page<FollowingDTO> findFollowingById(@Param("userId") UUID id, Pageable pageable);

    @Query("SELECT u FROM User u WHERE similarity(CONCAT(u.firstName, ' ', u.lastName),:keyword) > :threshold OR similarity(u.email, :keyword) > :threshold ORDER BY similarity(CONCAT(u.firstName, ' ', u.lastName),:keyword) DESC")
    Page<User> searchUserByKeyword(
            @Param("keyword") String keyword,
            Pageable pageable,
            @Param("threshold") double threshold);
}
