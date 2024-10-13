package hcmut.contentCreatorOnline.schemas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class jdbc {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    // private static String INSERT_QUERY = """
    // insert into creation(id, name, description)
    // values (2, 'vutruong khoa', 'test' )
    // """;

    private static String INSERT_QUERY = """
            insert into Creation(creationId, creationName, releaseDate, releaseStatus, saleOnly, salePrice)
            values (?, ?, ?, ?, ?, ?)
            """;

    private static String DELETE = """
            delete from creation
            where creationid = ?
            """;

    private static String SELECT_QUERY = """
            select * from creation
            where creationid = ?
            """;

    public void insert(Creation creation) {
        springJdbcTemplate.update(INSERT_QUERY,
                creation.getCreationId(), creation.getCreationName(), creation.getReleaseDate(),
                creation.isReleaseStatus(), creation.isSaleOnly(), creation.getSalePrice());
    }

    public void delete(long id) {
        springJdbcTemplate.update(DELETE, id);
    }

    public Creation findById(long id) {
        return springJdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Creation.class), id);
    }
}
