package com.mitocode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ModelNotFoundException extends RuntimeException{

    public ModelNotFoundException(String message) {
        super(message);
    }

}
