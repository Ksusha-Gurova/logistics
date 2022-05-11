package com.example.logistics.api;

import com.example.logistics.api.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

@RestControllerAdvice
public class ExceptionHandlers {
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorMessage handlerEntityNotFoundException (EntityNotFoundException e){
        return ErrorMessage.builder()
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PersistenceException.class)
    public ErrorMessage handlerPersistenceException(PersistenceException e){
        return ErrorMessage.builder()
                .message(e.getMessage())
                .build();
    }
}
