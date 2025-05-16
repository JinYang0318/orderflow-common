package com.orderflow_common.orderflow_common.exception;

import com.orderflow_common.orderflow_common.constant.MessageConstant.Error;
import com.orderflow_common.orderflow_common.model.response.ErrorResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
public class ApplicationException extends Exception {
    @Serial
    private static final long serialVersionUID = 4847202634178499059L;

    private final List<ErrorResponse> errorResponses;

    public ApplicationException(List<ErrorResponse> errorResponses) {
        this.errorResponses = errorResponses;
    }

    public ApplicationException(Error error) {
        this.errorResponses = List.of(
                ErrorResponse.builder()
                        .errorCode(error.errorCode)
                        .statusCode(error.status)
                        .errorMessage(error.errorMessage)
                        .build()
        );
    }
}
