package com.orderflow_common.orderflow_common.constant;


import lombok.Getter;

public class ResponseConstant {
    public static final String MDC_TRACE_ID = "traceId";

    private ResponseConstant() {
        throw new IllegalStateException("Constant Class");
    }

    @Getter
    public enum HttpStatusInfo {
        OK(200, "OK"),
        CREATED(201, "Created"),
        BAD_REQUEST(400, "Bad Request"),
        NOT_FOUND(404, "Not Found"),
        INTERNAL_SERVER_ERROR(500, "An Error Occurred While Processing Your Request.");

        private final int status;
        private final String title;

        HttpStatusInfo(int status, String title) {
            this.status = status;
            this.title = title;
        }
    }
}
