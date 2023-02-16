package com.todoapp.service;

import com.todoapp.exceptionHandler.AdminNotFoundMenagement;
import com.todoapp.exceptionHandler.NotAuthorized;
import com.todoapp.model.TaskModel;
import com.todoapp.repository.TaskRepository;
import com.todoapp.request.TaskRequest;
import com.todoapp.response.TaskResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskResponse createTask(TaskModel taskModel) {
        hashing(taskModel);
        TaskModel taskSaveModel=taskRepository.save(taskModel);
        return TaskResponse.convertToTaskResponse(taskSaveModel);
    }

    public void hashing(TaskModel passwordOfTaskModel){
        String sha256Pass = org.apache.commons.codec.digest.DigestUtils.sha256Hex(passwordOfTaskModel.getPassword());
        passwordOfTaskModel.setPassword(sha256Pass);
    }

    public List<TaskModel> findAll() {
        return taskRepository.findAll();
    }

    public TaskModel getById(int id) {
        return taskRepository.findById(id).orElseThrow(()->new RuntimeException("id numaralı task bulunamadı"));
    }

    public TaskModel deleteTask(int id) {
        Optional<TaskModel> task= Optional.ofNullable(taskRepository.findById(id).filter(taskModel -> taskModel.getManagement().equals("admin")).orElseThrow(() -> new NotAuthorized("silme yetkiniz yoktur")));
        taskRepository.deleteById(id);
        return task.get();

    }
    public TaskModel updateTask(int id, TaskModel task) {
        Optional<TaskModel> newTaskModel= Optional.ofNullable(taskRepository.findById(id).filter(taskModel -> taskModel.getManagement().equals("admin")).orElseThrow(() -> new NotAuthorized("güncelleme yetkiniz yoktur")));
        newTaskModel.get().setName(task.getName());
        newTaskModel.get().setDescription(task.getDescription());
        return taskRepository.save(newTaskModel.get());

    }
}
