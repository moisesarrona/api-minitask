package com.example.demo.errorhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private HttpStatus httpStatus;

    private String message;

    private Date timestamp;

    private List<ErrorItem> errorItem;

    public void addItem(String object, String field, String code, String message) {
        if (errorItem == null)
            errorItem = new ArrayList<>();
        errorItem.add(new ErrorItem(object, field, code, message));
    }

}
