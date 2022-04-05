package com.moisesarrona.minitask.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;

/**
 * @author moisesarrona
 * @version 0.1
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(InvalidDataException exception) {
        //BindingResult result = exception.getBindingResult();
        BindingResult result = exception.getResult();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        List<FieldError> fieldErrors = result.getFieldErrors();
        ErrorResponse response = new ErrorResponse();
        for (FieldError fieldError : fieldErrors) {
            response.addItem(fieldError.getObjectName(), fieldError.getField(), fieldError.getCode(), fieldError.getDefaultMessage());
        }

        return buildResponseEntity(httpStatus, new RuntimeException("Data invalid"), response.getErrorItem());
    }

    private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception exception, List<ErrorItem> errors) {
        ErrorResponse error = new ErrorResponse();
        error.setHttpStatus(httpStatus);
        error.setMessage(exception.getMessage());
        error.setTimestamp(new Date());
        error.setErrorItem(errors);
        return new ResponseEntity<>(error, httpStatus);
    }

}
