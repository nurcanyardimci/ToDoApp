package com.todoapp.request;

import com.todoapp.model.TaskModel;
import lombok.*;

@Setter
@Getter
@Builder
public class TaskRequest {
    private String name;
    private String password;
    private String description;
    private String management;

    public TaskModel convertToTaskModel(TaskRequest taskRequest){
        return TaskModel.builder()
                .name(taskRequest.getName())
                .password(password)
                .description(description)
                .management(management)
                .build();
    }


}
