package com.mitocode.exception;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handleDefaultException(Exception ex, WebRequest req){
        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleModelNotFoundException(ModelNotFoundException ex, WebRequest req){
        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
/*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest req){
        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
 */
/*
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest req) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

 */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest req) {
        String message = ex.getBindingResult().getFieldErrors().stream().map(error -> error.getField() +": "+ error.getDefaultMessage()).collect(Collectors.joining(", "));
        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), message, req.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
