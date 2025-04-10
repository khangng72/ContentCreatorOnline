package hcmut.contentCreatorOnline.controller.order;

import hcmut.contentCreatorOnline.dto.ApiResponse;
import hcmut.contentCreatorOnline.dto.order.*;
import hcmut.contentCreatorOnline.dto.user.UserDetailsImpl;
import hcmut.contentCreatorOnline.model.Order;
import hcmut.contentCreatorOnline.service.impl.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    public OrderService orderService;
    public OrderController(OrderService orderService) {this.orderService = orderService;}

    @PostMapping("/create")
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody @Valid OrderRequestDto dto) {
        OrderResponseDto response = orderService.createOrder(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable UUID id) {
        OrderResponseDto response = orderService.getOrderById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users/{id}/orders")
    public ResponseEntity<List<OrderHistoryDto>> getOrdersByUserId(@PathVariable UUID id) {
        List<OrderHistoryDto> orders = orderService.getOrdersByUserId(id);
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<OrderResponseDto> updateOrderStatus(@PathVariable UUID id,
                                                              @RequestBody UpdateOrderStatusRequest request) {
        Order updatedOrder = orderService.updateOrderStatus(id, OrderStatus.valueOf(request.getStatus()));
        OrderResponseDto dto = orderService.mapToOrderResponse(updatedOrder);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<OrderResponseDto> cancelOrder(@PathVariable UUID id) {
        OrderResponseDto cancelledOrder = orderService.cancelOrder(id);
        return ResponseEntity.ok(cancelledOrder);
    }


}