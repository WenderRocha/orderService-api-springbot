package com.wender.dev.orderServiceapi.resources.exceptions;


import com.wender.dev.orderServiceapi.services.exceptions.DataIntegratyViolationException;
import com.wender.dev.orderServiceapi.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, HttpServletRequest request) {
        StandardError error = new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegratyViolationException.class)
    public ResponseEntity<StandardError> DataIntegratyViolationException(DataIntegratyViolationException e, HttpServletRequest request) {
        StandardError error = new StandardError(Instant.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> MethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
       ValidationError error = new ValidationError(Instant.now(),HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos!", request.getRequestURI());

       for (FieldError x : e.getBindingResult().getFieldErrors()){
           error.addError(x.getField(), x.getDefaultMessage());
       }

       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
