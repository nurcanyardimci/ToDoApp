package com.todoapp.response;

import com.todoapp.model.TaskModel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class TaskResponse {

    private String name;
    private String description;
    private String management;

    public static TaskResponse convertToTaskResponse(TaskModel taskModel){
        return TaskResponse.builder().name(taskModel.getName()).description(taskModel.getDescription()).management(taskModel.getManagement()).build();
    }


}
