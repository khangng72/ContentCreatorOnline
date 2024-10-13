package hcmut.contentCreatorOnline.schemas;

import java.util.Date;

public class Creation {
    private Long creationId;
    private String creationName;
    private Date releaseDate;
    private boolean releaseStatus;
    private boolean saleOnly;
    private long salePrice;
    private long numberOfLikes;
    private long numberOfDislikes;
    private String coverImageURI;
    private String description;

    public Creation() {
    }

    public Creation(Long creationId, String creationName, Date releaseDate, boolean releaseStatus, boolean saleOnly,
            long salePrice, long numberOfLikes, long numberOfDislikes, String coverImageURI, String description) {
        this.creationId = creationId;
        this.creationName = creationName;
        this.releaseDate = releaseDate;
        this.releaseStatus = releaseStatus;
        this.saleOnly = saleOnly;
        this.salePrice = salePrice;
        this.numberOfLikes = numberOfLikes;
        this.numberOfDislikes = numberOfDislikes;
        this.coverImageURI = coverImageURI;
        this.description = description;
    }

    public Long getCreationId() {
        return creationId;
    }

    public void setCreationId(Long creationId) {
        this.creationId = creationId;
    }

    public String getCreationName() {
        return creationName;
    }

    public void setCreationName(String creationName) {
        this.creationName = creationName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(boolean releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    public boolean isSaleOnly() {
        return saleOnly;
    }

    public void setSaleOnly(boolean saleOnly) {
        this.saleOnly = saleOnly;
    }

    public long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(long salePrice) {
        this.salePrice = salePrice;
    }

    public long getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(long numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public long getNumberOfDislikes() {
        return numberOfDislikes;
    }

    public void setNumberOfDislikes(long numberOfDislikes) {
        this.numberOfDislikes = numberOfDislikes;
    }

    public String getCoverImageURI() {
        return coverImageURI;
    }

    public void setCoverImageURI(String coverImageURI) {
        this.coverImageURI = coverImageURI;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
