package hcmut.contentCreatorOnline.dto.CreationDTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class CreationHigestDTO {
    @Column(name = "creationName", length = 50, nullable = false)
    private String creationName;

    @Column(name = "numberOfLikes")
    private int numberOfLikes;

    @Column(name = "numberOfDislikes")
    private int numberOfDislikes;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "pen_name")
    private String penName;
}
