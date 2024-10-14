package hcmut.contentCreatorOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import hcmut.contentCreatorOnline.model.User.CCO_User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<CCO_User, UUID> {

    // NATIVE QUERY FOR DBS ASSIGNMENT
    @Query(value = "SELECT * FROM cco_user", nativeQuery = true)
    List<CCO_User> getAll();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cco_user (user_id, first_name, last_name, gender, user_password, birthday, nationality, email, is_admin) "
            +
            "VALUES (:user_id, :first_name, :last_name, :gender, :user_password, :birthday, :nationality, :email, :is_admin)", nativeQuery = true)
    void createNewUser(
            @Param("user_id") UUID user_id,
            @Param("first_name") String first_name,
            @Param("last_name") String last_name,
            @Param("gender") String gender,
            @Param("user_password") String user_password,
            @Param("birthday") LocalDate birthday,
            @Param("nationality") String nationality,
            @Param("email") String email,
            @Param("is_admin") boolean is_admin);

    @Query(value = "SELECT * FROM cco_user WHERE user_id = :user_id", nativeQuery = true)
    Optional<CCO_User> findUserById(@Param("user_id") UUID user_id);
}
