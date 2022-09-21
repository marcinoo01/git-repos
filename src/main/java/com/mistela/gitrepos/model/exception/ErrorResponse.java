package com.mistela.gitrepos.model.exception;

import com.fasterxml.jackson.annotation.JsonProperty;


public record ErrorResponse(@JsonProperty(value = "status_code")
                            Integer statusCode,
                            String message) {
}
