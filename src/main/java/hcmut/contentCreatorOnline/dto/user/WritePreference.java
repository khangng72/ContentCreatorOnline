package hcmut.contentCreatorOnline.dto.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WritePreference {
    private Double defaultWritingTextSize;
    private Double defaultWritingWordSpacing;
    private Double defaultWritingLineHeight;
}
