package com.moisesarrona.minitask.errorhandler;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.validation.BindingResult;

/**
 * @author moisesarrona
 * @version 0.1
 */
@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InvalidDataException extends RuntimeException {

    private final transient BindingResult result;

}
