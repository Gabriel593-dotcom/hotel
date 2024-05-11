package com.gabrieldev.userms.app.exception;

import com.gabrieldev.userms.domain.exception.RoleDoesNotExistsException;
import com.gabrieldev.userms.domain.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionStandardBody> throwsUserNotFound(Exception e) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        ExceptionStandardBody standardBody = ExceptionStandardBody.builder()
                .httpStatusCode(status.value())
                .messageError(e.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardBody);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RoleDoesNotExistsException.class)
    public ResponseEntity<ExceptionStandardBody> throwsRoleDoesNotExists(Exception e) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        ExceptionStandardBody standardBody = ExceptionStandardBody.builder()
                .httpStatusCode(status.value())
                .messageError(e.getMessage())
                .build();

        return ResponseEntity.status(status).body(standardBody);
    }
}
