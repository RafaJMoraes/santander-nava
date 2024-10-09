package com.nava.santander.controller.exceptions;


import com.nava.santander.controller.dtos.RestResponse;
import feign.FeignException;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ApiResponses(value = {
        @ApiResponse(content = @Content(schema = @Schema(implementation = RestResponse.class)))
})
@RestControllerAdvice
public class GlobalExceptionsHandler {


    @ApiResponses(value = {
            @ApiResponse(responseCode = "400",content = @Content(schema = @Schema(implementation = RestResponse.class)))
    })
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

    @ApiResponses(value = {
            @ApiResponse(responseCode = "404",content = @Content(schema = @Schema(implementation = RestResponse.class)))
    })
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
