package com.example.crud_factory.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler (RuntimeException.class)
    protected ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), null,
                LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler (ConstraintViolationException.class)
    protected ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException e) {

        List<ErrorMessage> errors =
                e.getConstraintViolations()
                        .stream()
                        .map(value -> new ErrorMessage(
                                value.getPropertyPath().toString(),
                                value.getInvalidValue(),
                                value.getMessage()))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(new ErrorResponse("Invalid parameter(s) found.", errors,
                LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

}
