package com.todoapp.request;

import com.todoapp.model.TaskModel;

public class ConvertToTaskModel {
    public TaskModel convertToTaskModel(TaskRequest taskRequest){
        return TaskModel.builder()
                .name(taskRequest.getName())
                .password(taskRequest.getPassword())
                .description(taskRequest.getDescription())
                .management(taskRequest.getManagement())
                .build();
    }
}
