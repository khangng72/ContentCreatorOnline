package hcmut.contentCreatorOnline.repository.creation;


import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CreationRepoEntityManager {

    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Object[]> getBooksHighestPoint(Integer top){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("get_books_highest_point");

        // Đăng ký tham số
        query.registerStoredProcedureParameter("p_top", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("result_set", void.class, ParameterMode.REF_CURSOR);

        // Gán giá trị tham số đầu vào
        query.setParameter("p_top", top);

        // Thực thi procedure
        query.execute();

        // Lấy kết quả từ con trỏ
        return query.getResultList();
    }

}
