package hcmut.contentCreatorOnline.repository.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hcmut.contentCreatorOnline.model.User.UserAccount;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, UUID> {
        Optional<UserAccount> findUserAccountByEmail(String email);

        // // NATIVE QUERY FOR DBS ASSIGNMENT
        // @Query(value = "SELECT * FROM cco_user", nativeQuery = true)
        // List<UserAccount> getAll();

        // @Modifying
        // @Transactional
        // @Query(value = "INSERT INTO cco_user (user_id, first_name, last_name, gender,
        // user_password, birthday, nationality, email, is_admin, address) "
        // +
        // "VALUES (:user_id, :first_name, :last_name, :gender, :user_password,
        // :birthday, :nationality, :email, :is_admin, :)", nativeQuery = true)
        // void createNewUser(
        // @Param("user_id") UUID user_id,
        // @Param("first_name") String first_name,
        // @Param("last_name") String last_name,
        // @Param("gender") String gender,
        // @Param("user_password") String user_password,
        // @Param("address") String address,
        // @Param("birthday") LocalDate birthday,
        // @Param("nationality") String nationality,
        // @Param("email") String email,
        // @Param("is_admin") boolean is_admin);

        // @Query(value = "SELECT * FROM cco_user WHERE user_id = :user_id", nativeQuery
        // = true)
        // Optional<UserAccount> findUserById(@Param("user_id") UUID user_id);

}
