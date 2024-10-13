package hcmut.contentCreatorOnline.schemas;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Creation {
    @Id
    private Long creationId;
    private String creationName;
    private Date releaseDate;
    private boolean releaseStatus;
    private boolean saleOnly;
    private long salePrice;

    public Creation() {

    }

    public Creation(Long creationId, java.lang.String creationName, Date releaseDate, boolean releaseStatus,
            boolean saleOnly, long salePrice) {
        this.creationId = creationId;
        this.creationName = creationName;
        this.releaseDate = releaseDate;
        this.releaseStatus = releaseStatus;
        this.saleOnly = saleOnly;
        this.salePrice = salePrice;
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

    @Override
    public String toString() {
        return "Creation [id " + creationId + "creation name " + creationName + "Release date " + releaseDate
                + "Release status " + releaseStatus + "saleOnly " + saleOnly + "Sale price" + salePrice + "]";
    }

}
