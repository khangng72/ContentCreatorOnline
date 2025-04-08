package hcmut.contentCreatorOnline.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
    private UUID orderId;
    private String orderDate;
    private Double totalPrice;
    private String status;

    private UUID userId;
    private String userName;

    private List<StorySummary> stories;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StorySummary {
        private UUID storyId;
        private String title;
        private Double salePrice;
    }
}

