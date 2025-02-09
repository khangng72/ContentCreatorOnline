package hcmut.contentCreatorOnline.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressUpdateRequest {
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
