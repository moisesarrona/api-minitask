package com.example.demo.errorhandler;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ErrorResponse {

    private HttpStatus status;

    private String message;

    private Date timestamp;

    private List<String> errors;
}
