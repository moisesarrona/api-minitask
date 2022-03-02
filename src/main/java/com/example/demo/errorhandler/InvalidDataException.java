package com.example.demo.errorhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.validation.BindingResult;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class InvalidDataException extends  RuntimeException {

    private final transient BindingResult result;

}
