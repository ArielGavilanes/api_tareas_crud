package com.yavirac.api_tareas_crud.tasks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yavirac.api_tareas_crud.tasks.model.Task;
import com.yavirac.api_tareas_crud.tasks.repository.TaskRepository;

@Service
public class TasksService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task findTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task createTask(Task newTask) {
        return taskRepository.save(newTask);
    }

    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id).orElse(null);

        task.setName(taskDetails.getName());
        task.setDescription(taskDetails.getDescription());

        return taskRepository.save(task);
    }

    public void deleteTask(long id){
        Task task = taskRepository.findById(id).orElse(null);
        taskRepository.delete(deleteTask);
    }
}
