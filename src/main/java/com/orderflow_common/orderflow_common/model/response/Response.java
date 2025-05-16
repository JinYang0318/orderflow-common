package com.orderflow_common.orderflow_common.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.orderflow_common.orderflow_common.Util.DateTimeUtils;
import com.orderflow_common.orderflow_common.constant.ResponseConstant;
import com.orderflow_common.orderflow_common.constant.ResponseConstant.HttpStatusInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.slf4j.MDC;
import org.springframework.http.ProblemDetail;

import java.io.Serial;
import java.time.OffsetDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response extends ProblemDetail {
    @Serial
    private static final long serialVersionUID = -3196290404287152052L;
    private Boolean isSuccess;
    private String traceId;
    private OffsetDateTime timeStamp;
    private List<ErrorResponse> errors;
    private Object data;

    public Response(boolean isSuccess, Object data, HttpStatusInfo statusInfo) {
        this.setTitle(statusInfo.getTitle());
        this.setStatus(statusInfo.getStatus());
        this.isSuccess = isSuccess;
        this.traceId = MDC.get(ResponseConstant.MDC_TRACE_ID);
        this.timeStamp = DateTimeUtils.getCurrentOffsetDateTime();
        this.data = data;
    }

    public Response(boolean isSuccess, List<ErrorResponse> errors, HttpStatusInfo statusInfo) {
        this.setTitle(statusInfo.getTitle());
        this.setStatus(statusInfo.getStatus());
        this.isSuccess = isSuccess;
        this.traceId = MDC.get(ResponseConstant.MDC_TRACE_ID);
        this.timeStamp = DateTimeUtils.getCurrentOffsetDateTime();
        this.data = errors;
    }
}
