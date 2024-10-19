package hcmut.contentCreatorOnline.schemas;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class jpa {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Creation creation) {
        entityManager.merge(creation);
    }

    public Creation findById(long id) {
        return entityManager.find(Creation.class, id);
    }

    public void deleteById(long id) {
        Creation creation = entityManager.find(Creation.class, id);
        entityManager.remove(creation);
    }
}
