package hcmut.contentCreatorOnline.dto.chapter;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetChaptersPagedResponse {
    Integer status;
    List<ChapterPageElement> result;
    Integer currentPage;
    Integer totalItems;
    Integer totalPages;
}
