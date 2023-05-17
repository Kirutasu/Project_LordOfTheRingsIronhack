package com.Ironhack.LOTRProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MethodNotAllowedExceptionHandler {

    @ExceptionHandler (HttpRequestMethodNotSupportedException.class)
    @ResponseStatus (HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public String methodNotAllowedExceptionHandler (HttpRequestMethodNotSupportedException exception) {
     return "la API del señor de los anillos no dispone de este método";
    }

}
