package com.orderflow_common.orderflow_common.constant;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class MessageConstant {
    private MessageConstant() {
        throw new IllegalStateException("MessageConstant Class");
    }

    @Getter
    public enum Error {
        Internal_ERROR ("Internal ERROR", HttpStatus.INTERNAL_SERVER_ERROR, "Unknown Exception is Occurred."),
        NOT_FOUND_ERROR("NOT FOUND", HttpStatus.NOT_FOUND, "Record Not Found In The System"),
        UNAUTHORIZED("Unauthorized", HttpStatus.UNAUTHORIZED, "You are not authorized to access this resource.");

        public final String errorCode;
        public final HttpStatus status;
        public final String errorMessage;

        Error(String errorCode, HttpStatus status, String errorMessage) {
            this.errorCode = errorCode;
            this.status = status;
            this.errorMessage = errorMessage;
        }
    }
}
