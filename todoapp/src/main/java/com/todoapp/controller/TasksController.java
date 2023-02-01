package com.todoapp.controller;
import com.todoapp.model.Tasks;
import com.todoapp.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/tasks")
public class TasksController {
@Autowired
private TasksService taskService;
    @PostMapping
    public Tasks createTask(@RequestBody Tasks task){

        return taskService.createTask(task);
    }

    @GetMapping
    public List<Tasks> findAll(){
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Tasks getById(@PathVariable int id){

        return taskService.getById(id);
    }

    @DeleteMapping(value="/{id}")
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Tasks deleteTask(@PathVariable int id){

        return taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public Tasks updateTask(@PathVariable int id,@RequestBody Tasks task){

        return taskService.updateTask(id,task);
    }


}
