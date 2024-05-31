package com.ao.mail.advice;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class EmailControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handlerFieldsErrors(MethodArgumentNotValidException exception){
        Map<String, String> errors = new HashMap<>();
    }
}