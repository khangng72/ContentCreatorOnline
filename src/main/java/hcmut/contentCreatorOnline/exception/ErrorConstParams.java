package hcmut.contentCreatorOnline.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorConstParams {
    private HttpStatus status;
    private String errorCode;
    private String occurredPoint;
    private String message;
}
