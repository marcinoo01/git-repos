package com.mistela.gitrepos.model.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {
    @JsonProperty(value = "status_code")
    private Integer statusCode;
    private String message;
}
