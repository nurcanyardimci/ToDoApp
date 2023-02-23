package com.todoapp.controller;
import com.todoapp.model.TaskModel;
import com.todoapp.request.ConvertTo;
import com.todoapp.request.TaskRequest;
import com.todoapp.response.TaskResponse;
import com.todoapp.service.TaskService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/tasks")

public class TasksController {
@Autowired
private TaskService taskService;
    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest taskRequest){
        TaskModel taskModel= ConvertTo.convertToTaskModel(taskRequest);
        return taskService.createTask(taskModel);
    }

    @GetMapping
    public List<TaskModel> findAll(){
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public TaskModel getById(@PathVariable int id){

        return taskService.getById(id);
    }

    @DeleteMapping(value="/{id}")
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public TaskModel deleteTask(@PathVariable int id){

        return taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public TaskModel updateTask(@PathVariable int id, @RequestBody TaskModel task){

        return taskService.updateTask(id,task);
    }


}
