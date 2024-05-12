package com.gabrieldev.authms.app.exception;

import com.gabrieldev.authms.domain.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExpcetionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionStandardBody> handleUserNotFound(Exception e) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        ExceptionStandardBody exceptionStandardBody = ExceptionStandardBody.builder()
                .httpStatusCode(status.value())
                .messageError(e.getMessage())
                .build();

        return ResponseEntity.status(status).body(exceptionStandardBody);
    }
}
