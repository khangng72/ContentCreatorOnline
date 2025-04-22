package hcmut.contentCreatorOnline.dto.story;

import hcmut.contentCreatorOnline.dto.user.UserResponseDTO;
import hcmut.contentCreatorOnline.model.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoryResponse {
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

    private Double averageRating;

//    private List<Chapter> chapters;

//    private Set<Genre> genres = new HashSet<>();
//
//    private Set<ReadList> readLists = new HashSet<>();
//
//    private Set<Order> orders = new HashSet<>();

//    private User userPost;
}