package hcmut.contentCreatorOnline.schemas;

import java.util.Date;

public class Comment {

    private String commentId;
    private Date commenDate;
    private String content;
    private Long numberOfLikes;
    private Long numberOfDislikes;
    private boolean isPinned;
    private String userId;
    private String creationId;

    public Comment() {
    }

    public Comment(String commentId, Date commenDate, String content, Long numberOfLikes, Long numberOfDislikes,
            boolean isPinned, String userId, String creationId) {
        this.commentId = commentId;
        this.commenDate = commenDate;
        this.content = content;
        this.numberOfLikes = numberOfLikes;
        this.numberOfDislikes = numberOfDislikes;
        this.isPinned = isPinned;
        this.userId = userId;
        this.creationId = creationId;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public Date getCommenDate() {
        return commenDate;
    }

    public void setCommenDate(Date commenDate) {
        this.commenDate = commenDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(Long numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public Long getNumberOfDislikes() {
        return numberOfDislikes;
    }

    public void setNumberOfDislikes(Long numberOfDislikes) {
        this.numberOfDislikes = numberOfDislikes;
    }

    public boolean isPinned() {
        return isPinned;
    }

    public void setPinned(boolean isPinned) {
        this.isPinned = isPinned;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreationId() {
        return creationId;
    }

    public void setCreationId(String creationId) {
        this.creationId = creationId;
    }

}
