package com.study.mf.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomResourceNotFound.class)
    public ResponseEntity<ResponseException> customNotFoundExceptionHandler(){
        return ResponseEntity.notFound().build();
    }
}
