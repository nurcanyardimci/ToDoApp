package com.todoapp.request;

import com.todoapp.model.TaskModel;

public class ConvertTo {
    public static TaskModel convertToTaskModel(TaskRequest taskRequest){
        return TaskModel.builder()
                .name(taskRequest.getName())
                .password(taskRequest.getPassword())
                .description(taskRequest.getDescription())
                .management(taskRequest.getManagement())
                .build();
    }
}
