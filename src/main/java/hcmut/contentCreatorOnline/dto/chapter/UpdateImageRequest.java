package hcmut.contentCreatorOnline.dto.chapter;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateImageRequest {
    private String chapterImageUri;
}
