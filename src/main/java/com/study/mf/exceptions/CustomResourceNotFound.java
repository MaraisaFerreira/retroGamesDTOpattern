package com.study.mf.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomResourceNotFound extends RuntimeException {
    public CustomResourceNotFound(String message) {
        super(message);
    }
}
