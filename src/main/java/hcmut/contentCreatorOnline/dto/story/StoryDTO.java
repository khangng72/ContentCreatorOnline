package hcmut.contentCreatorOnline.dto.story;

import hcmut.contentCreatorOnline.model.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoryDTO {
    private LocalDate releaseDate;

    private LocalDate createdDate;


    private Boolean releaseStatus;


    private String storyTitle;


    private Boolean saleOnly;


    private Double salePrice;


    private Integer numberOfLikes;


    private String coverImageUri;


    private String storyDescription;


    private String tags;

    private List<Chapter> chapters;

    private Set<Genre> genres = new HashSet<>();

    private Set<ReadList> readLists = new HashSet<>();

    private Set<Order> orders = new HashSet<>();

    private User userPost;
}
