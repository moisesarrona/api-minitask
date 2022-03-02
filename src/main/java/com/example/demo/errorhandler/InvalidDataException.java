package com.example.demo.errorhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.validation.BindingResult;

@Getter
@Setter
public class InvalidDataException extends  RuntimeException {

    private final transient BindingResult result;

    public InvalidDataException(BindingResult result) {
        super();
        this.result = result;
    }

    public InvalidDataException(String message, BindingResult result) {
        super(message);
        this.result = result;
    }

}
