package hcmut.contentCreatorOnline.service.impl;

import hcmut.contentCreatorOnline.dto.user.AddressUpdateRequest;
import hcmut.contentCreatorOnline.model.Address;
import hcmut.contentCreatorOnline.model.User;
import hcmut.contentCreatorOnline.repository.AddressRepository;
import hcmut.contentCreatorOnline.repository.UserRepository;
import hcmut.contentCreatorOnline.service.AddressCrudService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AddressCrudServiceImpl implements AddressCrudService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address GetAddress(UUID userId){
       User user = userRepository.findById(userId)
               .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

       Address address = user.getAddress();

       return address;

    }

    @Transactional
    public Address UpdateUserAddress(UUID userId, AddressUpdateRequest request){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        Address address = user.getAddress();

        if(address  == null){
            address = new Address();
            address.setAddressId(UUID.randomUUID());
        }

        if(request.getStreet() != null) address.setStreet(request.getStreet());
        if(request.getCity() != null) address.setCity(request.getCity());
        if(request.getState() != null) address.setUserState(request.getState());
        if(request.getPostalCode() != null) address.setPostalCode(request.getPostalCode());
        if(request.getCountry() != null) address.setCountry(request.getCountry());

        addressRepository.save(address);

        if (user.getAddress() == null){
            user.setAddress(address);
            userRepository.save(user);
        }

        return address;
    };
}
