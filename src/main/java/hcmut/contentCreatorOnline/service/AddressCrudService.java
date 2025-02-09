package hcmut.contentCreatorOnline.service;


import hcmut.contentCreatorOnline.dto.user.AddressUpdateRequest;
import hcmut.contentCreatorOnline.model.Address;

import java.util.UUID;

public interface AddressCrudService {
    Address UpdateUserAddress(UUID userId, AddressUpdateRequest request);
    Address GetAddress(UUID userId);
}
