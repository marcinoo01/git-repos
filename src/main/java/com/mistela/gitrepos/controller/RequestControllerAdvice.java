package com.mistela.gitrepos.controller;

import com.mistela.gitrepos.model.exception.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice(basePackageClasses = RequestController.class)
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestControllerAdvice {

    private static final String USER_NOT_EXIST_IN_GITHUB_MSG = "Provided username currently does not exist in github";

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementFoundException() {
        final ErrorResponse response = new ErrorResponse(NOT_FOUND.value(), USER_NOT_EXIST_IN_GITHUB_MSG);
        return ResponseEntity
                .status(NOT_FOUND)
                .body(response);
    }
}
