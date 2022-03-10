package com.example.demo.errorhandler;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.validation.BindingResult;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InvalidDataException extends RuntimeException {

    private final transient BindingResult result;

}
