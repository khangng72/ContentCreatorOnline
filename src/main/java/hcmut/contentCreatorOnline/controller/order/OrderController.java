package hcmut.contentCreatorOnline.controller.order;

import hcmut.contentCreatorOnline.dto.ApiResponse;
import hcmut.contentCreatorOnline.dto.order.OrderRequestDto;
import hcmut.contentCreatorOnline.dto.order.OrderResponseDto;
import hcmut.contentCreatorOnline.service.impl.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    public OrderService orderService;
    public OrderController(OrderService orderService) {this.orderService = orderService;}

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<OrderResponseDto>> createOrder(@RequestBody @Valid OrderRequestDto dto) {
        OrderResponseDto response = orderService.createOrder(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(201, response));
    }

}