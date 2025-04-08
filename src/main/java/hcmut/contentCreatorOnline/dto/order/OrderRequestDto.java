package hcmut.contentCreatorOnline.dto.order;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OrderRequestDto {
    private UUID userId;
    private List<UUID> storyIds;
}

