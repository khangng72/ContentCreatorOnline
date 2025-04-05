package hcmut.contentCreatorOnline.dto.chapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewChapterResponseDTO {
    private UUID chapterId;
    private UUID storyId;
}
