package com.todoapp.exceptionHandler;

public class AdminNotFoundMenagement extends RuntimeException {
    public AdminNotFoundMenagement(String message){

        super(message );
    }
}
