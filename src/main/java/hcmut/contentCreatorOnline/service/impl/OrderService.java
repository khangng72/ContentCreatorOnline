package hcmut.contentCreatorOnline.service.impl;

import hcmut.contentCreatorOnline.dto.order.OrderRequestDto;
import hcmut.contentCreatorOnline.dto.order.OrderResponseDto;
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
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        order.setStatus("PENDING");
        order.setOrderDate(LocalDate.now());

        orderRepository.save(order);

        // Chuẩn bị response DTO
        List<OrderResponseDto.StorySummary> storySummaries = stories.stream()
                .map(s -> new OrderResponseDto.StorySummary(s.getStoryId(), s.getStoryTitle(), s.getSalePrice()))
                .toList();

        return new OrderResponseDto(
                order.getOrderId(),
                order.getOrderDate().toString(),
                order.getTotalPrice(),
                order.getStatus(),
                user.getId(),
                user.getFirstName() + " " + user.getLastName(),
                storySummaries
        );
    }

}
