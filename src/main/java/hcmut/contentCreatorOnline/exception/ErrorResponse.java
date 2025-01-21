package hcmut.contentCreatorOnline.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private String errorCode;
    private String errorMessage;
    private String additionalInfo;
}
