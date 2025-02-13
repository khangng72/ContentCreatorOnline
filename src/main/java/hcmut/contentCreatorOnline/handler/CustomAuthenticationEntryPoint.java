package hcmut.contentCreatorOnline.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import hcmut.contentCreatorOnline.exception.ErrorConst;
import hcmut.contentCreatorOnline.exception.ErrorResponse;
import hcmut.contentCreatorOnline.utils.LoggerUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Logger logger = LoggerUtil.getLogger(this.getClass());

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        logger.error("Error because: {}", authException.toString());
        handleException(response, "Unauthorized access", HttpStatus.UNAUTHORIZED);
    }

    private void handleException(HttpServletResponse response, String message, HttpStatus status) throws IOException {
        response.setStatus(status.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ErrorResponse errorResponse = new ErrorResponse(status.value(), ErrorConst.UNAUTHORIZED.getErrorCode(), message,
                null);
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
