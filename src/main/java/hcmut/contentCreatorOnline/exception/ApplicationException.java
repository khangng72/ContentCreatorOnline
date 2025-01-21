package hcmut.contentCreatorOnline.exception;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {

    private final ErrorConstParams errorConst;
    private final String additionalInfo;

    // Constructor to initialize error const and additional info
    public ApplicationException(ErrorConstParams errorConst, String additionalInfo) {
        super(errorConst.getMessage());
        this.errorConst = errorConst;
        this.additionalInfo = additionalInfo;
    }

    // Constructor to initialize error const
    public ApplicationException(ErrorConstParams errorConst) {
        super(errorConst.getMessage());
        this.errorConst = errorConst;
        this.additionalInfo = "";
    }

    // Constructor to initialize additional info
    public ApplicationException(String additionalInfo) {
        super(ErrorConst.UNEXPECTED_ERROR.getMessage());
        this.errorConst = ErrorConst.UNEXPECTED_ERROR;
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String getMessage() {
        return errorConst.getMessage();
    }

    public HttpStatus getStatus() {
        return errorConst.getStatus();
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public String getErrorCode() {
        return errorConst.getErrorCode();
    }

    public String getOccurredPoint() {
        return errorConst.getOccurredPoint();
    }

    public ErrorConstParams getErrorConst() {
        return errorConst;
    }
}
