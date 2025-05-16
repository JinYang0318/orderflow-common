package com.orderflow_common.orderflow_common.config;

import com.orderflow_common.orderflow_common.constant.ResponseConstant.HttpStatusInfo;
import com.orderflow_common.orderflow_common.exception.ApplicationException;
import com.orderflow_common.orderflow_common.model.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ApplicationContextException.class})
    public ResponseEntity<Object> handleApplicationContextException(ApplicationException ex) {
        Response response = new Response(
                false,
                ex.getErrorResponses(),
                getHttpStatusInfoFromError(ex.getErrorResponses().get(0).getStatusCode())
        );

        return ResponseEntity.status(response.getStatus()).body(response);
    }

    private HttpStatusInfo getHttpStatusInfoFromError(HttpStatus httpStatus) {
        return switch (httpStatus) {
            case BAD_REQUEST -> HttpStatusInfo.BAD_REQUEST;
            case NOT_FOUND -> HttpStatusInfo.NOT_FOUND;
            case UNAUTHORIZED -> HttpStatusInfo.UNAUTHORIZED;
            default -> HttpStatusInfo.INTERNAL_SERVER_ERROR;
        };
    }

}
