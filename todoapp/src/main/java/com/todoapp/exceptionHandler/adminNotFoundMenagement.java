package com.todoapp.exceptionHandler;

public class adminNotFoundMenagement extends RuntimeException {
    public adminNotFoundMenagement(String message){
        super(message );
    }
}
