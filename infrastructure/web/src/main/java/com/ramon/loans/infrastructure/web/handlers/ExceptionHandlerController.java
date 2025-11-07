package com.ramon.loans.infrastructure.web.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ramon.loans.infrastructure.web.dto.ValidationError;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(exception = MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validationError(MethodArgumentNotValidException e) {
        ValidationError err = ValidationError.from(e);
        return ResponseEntity.status(err.getStatus()).body(err);
    }

}
