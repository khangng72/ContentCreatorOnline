package hcmut.contentCreatorOnline.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistoryDto {
    private UUID orderId;
    private LocalDate orderDate;
    private Double totalPrice;
    private String status;
    private List<StoryItem> stories;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StoryItem {
        private UUID storyId;
        private String title;
        private Double salePrice;
    }
}

