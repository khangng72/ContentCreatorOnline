package hcmut.contentCreatorOnline.service.impl;

import hcmut.contentCreatorOnline.dto.order.OrderHistoryDto;
import hcmut.contentCreatorOnline.dto.order.OrderRequestDto;
import hcmut.contentCreatorOnline.dto.order.OrderResponseDto;
import hcmut.contentCreatorOnline.dto.order.OrderStatus;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.model.Order;
import hcmut.contentCreatorOnline.model.Story;
import hcmut.contentCreatorOnline.model.User;
import hcmut.contentCreatorOnline.repository.OrderRepository;
import hcmut.contentCreatorOnline.repository.StoryRepository;
import hcmut.contentCreatorOnline.repository.UserRepository;
import hcmut.contentCreatorOnline.service.UserService;
import hcmut.contentCreatorOnline.utils.LoggerUtil;
import jakarta.transaction.Transactional;
import org.springframework.security.access.AccessDeniedException;

import org.apache.coyote.BadRequestException;

import org.slf4j.Logger;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final UserRepository userRepository;
    private static final Logger logger = LoggerUtil.getLogger(UserService.class);
    private final OrderRepository orderRepository;
    private final StoryRepository storyRepository;

    public OrderService(UserRepository userRepository, OrderRepository orderRepository, StoryRepository storyRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.storyRepository = storyRepository;
    }
    private OrderResponseDto mapToOrderResponse(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setOrderId(order.getOrderId());
        dto.setOrderDate(order.getOrderDate());
        dto.setStatus(order.getStatus().name());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setUserId(order.getUserId().getId());

        String fullName = order.getUserId().getFirstName() + " " + order.getUserId().getLastName();
        dto.setUserName(fullName);

        List<OrderResponseDto.StorySummary> storySummaries = order.getProduces().stream()
                .map(story -> new OrderResponseDto.StorySummary(
                        story.getStoryId(),
                        story.getStoryTitle(),
                        story.getSalePrice()
                ))
                .collect(Collectors.toList());

        dto.setStories(storySummaries);
        return dto;
    }




    @Transactional
    public OrderResponseDto createOrder(OrderRequestDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "User not found"));

        Set<Story> stories = new HashSet<>(storyRepository.findAllById(dto.getStoryIds()));

        double totalPrice = stories.stream()
                .mapToDouble(s -> s.getSalePrice() != null ? s.getSalePrice() : 0)
                .sum();

        Order order = new Order();
        order.setUserId(user);
        order.setProduces(stories);
        order.setTotalPrice(totalPrice);
        order.setStatus(OrderStatus.valueOf("PENDING"));
        order.setOrderDate(LocalDate.now());

        orderRepository.save(order);

        // Chuẩn bị response DTO
        List<OrderResponseDto.StorySummary> storySummaries = stories.stream()
                .map(s -> new OrderResponseDto.StorySummary(s.getStoryId(), s.getStoryTitle(), s.getSalePrice()))
                .toList();

        return new OrderResponseDto(
                order.getOrderId(),
                order.getOrderDate(),
                order.getTotalPrice(),
                order.getStatus().name(),
                user.getId(),
                user.getFirstName() + " " + user.getLastName(),
                storySummaries
        );
    }

    public OrderResponseDto getOrderById(UUID orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Order not found"));

        OrderResponseDto dto = new OrderResponseDto();
        dto.setOrderId(order.getOrderId());
        dto.setOrderDate(order.getOrderDate());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setStatus(order.getStatus().name());

        dto.setUserId(order.getUserId().getId());
        dto.setUserName(order.getUserId().getFirstName() + " " + order.getUserId().getLastName());

        List<OrderResponseDto.StorySummary> storyDtos = order.getProduces().stream()
                .map(story -> new OrderResponseDto.StorySummary(
                        story.getStoryId(),
                        story.getStoryTitle(),
                        story.getSalePrice()
                )).collect(Collectors.toList());


        dto.setStories(storyDtos);
        return dto;
    }

    public List<OrderHistoryDto> getOrdersByUserId(UUID userId) {
        List<Order> orders = orderRepository.findByUserId_Id(userId); // vì bạn dùng userId là User object

        return orders.stream().map(order -> {
            List<OrderHistoryDto.StoryItem> storyItems = order.getProduces().stream().map(story ->
                    new OrderHistoryDto.StoryItem(
                            story.getStoryId(),
                            story.getStoryTitle(),
                            story.getSalePrice()
                    )
            ).collect(Collectors.toList());

            return new OrderHistoryDto(
                    order.getOrderId(),
                    order.getOrderDate(),
                    order.getTotalPrice(),
                    order.getStatus().name(),
                    storyItems
            );
        }).collect(Collectors.toList());
    }

    public OrderResponseDto updateOrderStatus(UUID orderId, String status, UUID currentUserId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "Order not found"));

        User currentUser = userRepository.findById(currentUserId)
                .orElseThrow(() -> new ApplicationException(ErrorConst.RESOURCE_NOT_FOUND, "User not found"));

        // Chỉ admin mới được update đơn hàng của người khác
        if (!order.getUserId().getId().equals(currentUserId) && !currentUser.isAdmin()) {
            throw new AccessDeniedException("You are not allowed to update this order");
        }

            OrderStatus newStatus = OrderStatus.valueOf(status.toUpperCase());
            order.setStatus(newStatus); // Gán chuỗi "PENDING", "COMPLETED",...
            orderRepository.save(order);


        return mapToOrderResponse(order);
    }

}
