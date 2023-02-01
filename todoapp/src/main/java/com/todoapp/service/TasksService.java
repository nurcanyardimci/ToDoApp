package com.todoapp.service;

import com.todoapp.exceptionHandler.adminNotFoundMenagement;
import com.todoapp.model.Tasks;
import com.todoapp.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class TasksService {
    @Autowired
    private TaskRepository taskRepository;

    public Tasks createTask(Tasks task) {
        hashing(task);
        return taskRepository.save(task);
    }

    public void hashing(Tasks taskRequest){
        String sha256Pass = org.apache.commons.codec.digest.DigestUtils.sha256Hex(taskRequest.getPassword());
        taskRequest.setPassword(sha256Pass);
    }

    public List<Tasks> findAll() {
        return taskRepository.findAll();
    }

    public Tasks getById(int id) {
        return taskRepository.findById(id).get();
    }

    public Tasks deleteTask(int id) {
        Tasks task=taskRepository.findById(id).get();
        if(task.management.equals("admin")){
            taskRepository.deleteById(id);
            log.info("görevi silmek için yetkiniz bulunmaktadır");
            return task;
        }
        log.info("görev silme yetkiniz yoktur");

            throw new adminNotFoundMenagement("silme yetkiniz yoktur");

    }
    public Tasks updateTask(int id, Tasks task) {
        Tasks task1 = taskRepository.findById(id).get();
        task1.setName(task.getName());
        if (task.management.equals("admin")) {
            task1.setDescription(task.getDescription());
            log.info("görevi güncellemek için yetkiniz bulunmaktadır");
            return taskRepository.save(task1);
        }
        log.info("görev güncelleme yetkiniz yoktur");
        return task;
    }
}
