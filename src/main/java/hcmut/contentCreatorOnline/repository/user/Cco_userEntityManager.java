package hcmut.contentCreatorOnline.repository.user;



import jakarta.persistence.EntityManager;

import jakarta.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class Cco_userEntityManager {
    @Autowired
    private EntityManager entityManager;

//    public CCOUserDTO getCCOUser(String gender){
//        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("get_user_by_gender");
//
//        query.registerStoredProcedureParameter("gender", Integer.class, ParameterMode.IN);
//        query.registerStoredProcedureParameter("address", String.class, ParameterMode.OUT);
//        query.registerStoredProcedureParameter("birthday", String.class, ParameterMode.OUT);
//        query.registerStoredProcedureParameter("firstName", String.class, ParameterMode.OUT);
//        query.registerStoredProcedureParameter("email", String.class, ParameterMode.OUT);
//
//        query.setParameter("gender",gender );
//
//        query.execute();
//
//        // Lấy giá trị từ tham số OUT
//        String address = (String) query.getOutputParameterValue("address");
//        String birthday = (String) query.getOutputParameterValue("birthday");
//        String firstName = (String) query.getOutputParameterValue("firstName");
//        String email = (String) query.getOutputParameterValue("email");
//
//
//        // Trả kết quả về đối tượng
//        CCOUserDTO ccoUserDTO = new CCOUserDTO();
//        ccoUserDTO.setAddress(address);
//        ccoUserDTO.setEmail(email);
//        ccoUserDTO.setBirthday(birthday);
//        ccoUserDTO.setFirst_name(firstName);
//
//        return ccoUserDTO;
//    }

    @SuppressWarnings("unchecked")
    public List<Object[]> getCCOUser(String input_gender) {
        // Tạo StoredProcedureQuery
//        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("get_user_by_gender");
//
//        query.registerStoredProcedureParameter("gender", String.class, ParameterMode.IN);
//
//        query.setParameter("gender", gender);
//        // Thực thi procedure
//        query.execute();
//
//        // Lấy danh sách kết quả
//        List<Object[]> results = query.getResultList();
//
//        return results;

        Query query = entityManager.createNativeQuery("SELECT * FROM get_user_by_gender(:gender)");
        query.setParameter("gender", input_gender); // Truyền giá trị tham số

        // Thực thi và trả về kết quả
        return query.getResultList();
    }
}
