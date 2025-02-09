package hcmut.contentCreatorOnline.controller.user;

import hcmut.contentCreatorOnline.dto.user.AddressUpdateRequest;
import hcmut.contentCreatorOnline.model.Address;
import hcmut.contentCreatorOnline.service.impl.AddressCrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/address")
public class AddressCrudController {
    @Autowired
    private AddressCrudServiceImpl addressCrudService;

    @GetMapping("/{userId}")
    public Address GetAddress(@PathVariable UUID userId){
        return addressCrudService.GetAddress(userId);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Address> updateUserAddress(
            @PathVariable UUID userId,
            @RequestBody AddressUpdateRequest request
    ){
        Address updateAddress = addressCrudService.UpdateUserAddress(userId, request);
        return ResponseEntity.ok(updateAddress);
    }


}
