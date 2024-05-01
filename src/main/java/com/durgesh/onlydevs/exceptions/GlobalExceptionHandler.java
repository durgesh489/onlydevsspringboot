package com.durgesh.onlydevs.exceptions;

import com.durgesh.onlydevs.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullFieldException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiResponse> handleNullFieldException(NullFieldException ex, HttpServletRequest request) {
        ApiResponse response = new ApiResponse(HttpStatus.BAD_REQUEST,ex.getMessage().toString(),request.getRequestURI(), null,false);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
