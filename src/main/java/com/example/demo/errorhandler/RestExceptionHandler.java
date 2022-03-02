package com.example.demo.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handlerException(InvalidDataException exception) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        List<String> errors = exception.getResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        return buildResponseEntity(httpStatus, new RuntimeException("Data invalid"), errors);
    }

    private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception exception, List<String> errors) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage(exception.getMessage());
        error.setStatus(httpStatus);
        error.setTimestamp(new Date());
        return new ResponseEntity<>(error, httpStatus);
    }

}
