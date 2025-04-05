package hcmut.contentCreatorOnline.dto.chapter;

import lombok.Data;

@Data
public class ChapterRequest {
    private String chapterTitle;
    private String chapterDescription;
    private String chapterImageUri;
}
