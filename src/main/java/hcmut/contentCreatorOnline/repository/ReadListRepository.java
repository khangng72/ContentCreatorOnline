package hcmut.contentCreatorOnline.repository;

import hcmut.contentCreatorOnline.model.ReadList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReadListRepository extends JpaRepository<ReadList, UUID> {
    List<ReadList> findAllByUserCreated_Id(UUID userId);
}
