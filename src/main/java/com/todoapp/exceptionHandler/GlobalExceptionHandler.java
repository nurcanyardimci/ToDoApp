package com.todoapp.exceptionHandler;


import com.todoapp.response.NotAuthorizedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(NotAuthorized.class)
        public ResponseEntity<NotAuthorizedResponse> handle(NotAuthorized exception) {
            return ResponseEntity.ok(new NotAuthorizedResponse(exception.getMessage(), HttpStatus.BAD_REQUEST));
        }

    }

