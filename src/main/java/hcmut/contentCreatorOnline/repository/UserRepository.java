package hcmut.contentCreatorOnline.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import hcmut.contentCreatorOnline.model.User;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
//    @Procedure("CCO_UPDATE_ADDRESS")
//    void updateUserAddress(
//            @Param("p_userId") UUID userId,
//            @Param("p_street") String street,
//            @Param("p_city") String city,
//            @Param("p_user_state") String state,
//            @Param("p_postal_code") String postalCode,
//            @Param("p_country") String country
//    );
}
