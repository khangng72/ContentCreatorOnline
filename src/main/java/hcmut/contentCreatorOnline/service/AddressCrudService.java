package hcmut.contentCreatorOnline.service;


import hcmut.contentCreatorOnline.dto.user.AddressUpdateRequest;
import hcmut.contentCreatorOnline.model.Address;

import java.util.UUID;

public interface AddressCrudService {
    Address createUserAddress(UUID userId, AddressUpdateRequest request);

    Address getAddress(UUID userId);

    String deleteAddress(UUID userId);
}
