package hcmut.contentCreatorOnline.controller.user;

import hcmut.contentCreatorOnline.dto.user.AddressUpdateRequest;
import hcmut.contentCreatorOnline.model.Address;
import hcmut.contentCreatorOnline.service.AddressCrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/address")
public class AddressCrudController {
    private final AddressCrudService addressCrudService;

    public AddressCrudController(AddressCrudService addressCrudService) {
        this.addressCrudService = addressCrudService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Address> getAddress(@PathVariable UUID userId) {
        Address address = addressCrudService.getAddress(userId);

        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Address> createUserAddress(
            @PathVariable UUID userId,
            @RequestBody AddressUpdateRequest request
    ) {
        Address updateAddress = addressCrudService.createUserAddress(userId, request);
        return ResponseEntity.ok(updateAddress);
    }

    @DeleteMapping("/{userId}")
    public String deleteAddress(@PathVariable UUID userId) {
        return addressCrudService.deleteAddress(userId);
    }
}
