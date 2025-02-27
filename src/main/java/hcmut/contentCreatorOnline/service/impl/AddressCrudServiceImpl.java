package hcmut.contentCreatorOnline.service.impl;

import hcmut.contentCreatorOnline.dto.user.AddressUpdateRequest;
import hcmut.contentCreatorOnline.model.Address;
import hcmut.contentCreatorOnline.model.User;
import hcmut.contentCreatorOnline.repository.AddressRepository;
import hcmut.contentCreatorOnline.repository.UserRepository;
import hcmut.contentCreatorOnline.service.AddressCrudService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressCrudServiceImpl implements AddressCrudService {
    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    public AddressCrudServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Address getAddress(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        return user.getAddress();

    }

    @Override
    public Address createUserAddress(UUID userId, AddressUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        Address address = user.getAddress();

        if (address == null) {
            address = new Address();
            address.setAddressId(UUID.randomUUID());
        }

        if (request.getStreet() != null) address.setStreet(request.getStreet());
        if (request.getCity() != null) address.setCity(request.getCity());
        if (request.getState() != null) address.setUserState(request.getState());
        if (request.getPostalCode() != null) address.setPostalCode(request.getPostalCode());
        if (request.getCountry() != null) address.setCountry(request.getCountry());

        addressRepository.save(address);

        if (user.getAddress() == null) {
            user.setAddress(address);
            userRepository.save(user);
        }

        return address;
    }

    @Override
    public String deleteAddress(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        Address address = user.getAddress();

        if (address == null) {
            throw new RuntimeException("User does not have an address to delete");
        }

        user.setAddress(null);
        userRepository.save(user);

        addressRepository.deleteById(address.getAddressId());

        return "Delete successful";
    }


}
