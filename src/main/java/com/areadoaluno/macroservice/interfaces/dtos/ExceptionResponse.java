package com.areadoaluno.macroservice.interfaces.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class ExceptionResponse {
    String message;
    Map<String, String> errors;

    public ExceptionResponse(String message) {
        this.message = message;
        this.errors = null;
    }
}
