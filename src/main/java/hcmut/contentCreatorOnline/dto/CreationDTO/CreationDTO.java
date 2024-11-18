package hcmut.contentCreatorOnline.dto.CreationDTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class CreationDTO {

    @Column(name = "creationName", length = 50, nullable = false)
    private String creationName;

    @Column(name = "salePrice")
    private Double salePrice;

    @Column(name = "numberOfLikes")
    private BigInteger numberOfLikes;

    @Column(name = "numberOfDislikes")
    private BigInteger numberOfDislikes;

    @Column(name = "coverImageURI", length = 250)
    private String coverImageURI;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "tags")
    private String Tags;
}
