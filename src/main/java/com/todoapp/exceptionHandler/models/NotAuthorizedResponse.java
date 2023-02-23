package com.todoapp.exceptionHandler.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotAuthorizedResponse {
    private String message;
    private HttpStatus httpStatus;
}
