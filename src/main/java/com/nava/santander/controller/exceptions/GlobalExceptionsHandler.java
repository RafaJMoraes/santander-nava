package com.nava.santander.controller.exceptions;


import com.nava.santander.controller.dtos.RestResponse;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExceptionsHandler {


    @ExceptionHandler(FeignException.BadRequest.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> badRequestCEP (FeignException.BadRequest error, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                RestResponse.builder()
                        .message(error.getMessage())
                        .code(HttpStatus.NOT_FOUND.value())
                        .errors(error)
                        .build());
    }

    @ExceptionHandler(FeignException.NotFound.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> notFoundCEP (FeignException.NotFound error) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                RestResponse.builder()
                        .message(error.getMessage())
                        .code(HttpStatus.NOT_FOUND.value())
                        .errors(error)
                        .build());
    }
}
