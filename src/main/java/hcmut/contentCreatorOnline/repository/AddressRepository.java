package hcmut.contentCreatorOnline.repository;

import hcmut.contentCreatorOnline.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
