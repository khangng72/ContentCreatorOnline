package hcmut.contentCreatorOnline.dto.chapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterRequest {
    private String chapterTitle;
    private String chapterDescription;
    private String ChapterContent;
    private String chapterImageUri;
}
