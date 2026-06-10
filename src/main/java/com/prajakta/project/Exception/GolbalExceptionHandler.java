package com.prajakta.project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GolbalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErroDetails> handleTaskNotFoundexception(TaskNotFoundException taskNotFoundException, WebRequest webRequest){
        ErroDetails erroDetails = new ErroDetails(
                LocalDateTime.now(),
                taskNotFoundException.getMessage(),
                webRequest.getDescription(false),
                "TASK_NOT_FOUND"
        );

        return new ResponseEntity<>(erroDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErroDetails> handlGlobalException(RuntimeException runtimeException, WebRequest webRequest){
        ErroDetails erroDetails = new ErroDetails(

                LocalDateTime.now(),
                runtimeException.getMessage(),
                webRequest.getDescription(false),
                "BAD_REQUEST");

        return new ResponseEntity<>(erroDetails, HttpStatus.BAD_REQUEST);
    }
}
