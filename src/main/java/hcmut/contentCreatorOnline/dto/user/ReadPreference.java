package hcmut.contentCreatorOnline.dto.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ReadPreference {
    private Double defaultReadingTextSize;
    private Double defaultReadingWordSpacing;
    private Double defaultReadingLineHeight;
}
