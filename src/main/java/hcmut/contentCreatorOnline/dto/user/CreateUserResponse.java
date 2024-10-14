package hcmut.contentCreatorOnline.dto.user;

public class CreateUserResponse {
    private int status;
    private CreateUserResult result;
    private String message;

    public CreateUserResponse(int status, CreateUserResult result, String message) {
        this.status = status;
        this.result = result;
        this.message = message;
    }

    public CreateUserResponse() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public CreateUserResult getResult() {
        return result;
    }

    public void setResult(CreateUserResult result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
