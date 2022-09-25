package com.mistela.gitrepos.controller;

import com.mistela.gitrepos.model.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

@ControllerAdvice
public class ErrorControllerAdvice {

    private static final String SERVICE_UNAVAILABLE_MSG = "Server is unavailable";

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<ErrorResponse> handleServerException() {
        final ErrorResponse response = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(), SERVICE_UNAVAILABLE_MSG);
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(response);
    }
}
