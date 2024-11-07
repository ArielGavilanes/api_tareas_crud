package com.yavirac.api_tareas_crud.tasks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yavirac.api_tareas_crud.tasks.model.Task;
import com.yavirac.api_tareas_crud.tasks.repository.TasksRepository;


@Service
public class TasksService {
    @Autowired
    private TasksRepository tasksRepository;

    public List<Task> getAllTasks() {
        return tasksRepository.findAll();
    }
    
    public Task findTaskById(Long id) {
        return tasksRepository.findById(id).orElse(null);
    }

    public Task createTask(Task newTask ){
        return tasksRepository.save(newTask);
    }
}
