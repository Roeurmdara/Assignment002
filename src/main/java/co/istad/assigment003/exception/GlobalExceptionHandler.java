package co.istad.assigment003.exception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse<?> handleValidationException(MethodArgumentNotValidException e) {
        log.error("Validation Exception happened: {}", e.getMessage());

        List<FieldErrorResponse> fields = new ArrayList<>();

        // Loop through field errors and build the responses
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            FieldErrorResponse field = FieldErrorResponse.builder()
                    .field(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .build();
            fields.add(field);
        });

        // Return the generic wildcard ErrorResponse
        return ErrorResponse.builder()
                .status(false)
                .code(HttpStatus.BAD_REQUEST.value())
                .message("Validation is errored")
                .errors(fields)
                .build();
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handle500(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of(
                        "message", ex.getMessage(),
                        "status", 500
                ));
    }
}