package hcmut.contentCreatorOnline.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class UpdateUserDTO {
    @NotNull(message = "firstName is null")
    private String firstName;

    @NotNull(message = "lastName is null")
    private String lastName;

    @NotNull(message = "gender is null")
    private String gender;

    @NotNull(message = "nationality is null")
    private String nationality;

    @NotNull(message = "birthday is null")
    private LocalDate birthday;
}
