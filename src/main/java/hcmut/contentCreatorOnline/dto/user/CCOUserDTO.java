package hcmut.contentCreatorOnline.dto.user;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CCOUserDTO {
    private static final long serialVersionUID = 1L;

    private String first_name;

    private Date birthday;

    private String email;

    private String address;
}
