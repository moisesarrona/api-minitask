package com.example.demo.errorhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorItem {

    private String object;

    private String field;

    private String code;

    private String message;

}
