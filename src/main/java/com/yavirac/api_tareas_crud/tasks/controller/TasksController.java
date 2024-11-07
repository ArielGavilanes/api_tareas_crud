package com.yavirac.api_tareas_crud.tasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yavirac.api_tareas_crud.tasks.model.Task;
import com.yavirac.api_tareas_crud.tasks.service.TasksService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {
    @Autowired
    private TasksService tasksService;

    @GetMapping("/")
    public List<Task> getAllTasks() {
        return tasksService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task findTaskById(@PathVariable Long id) {
        return tasksService.findTaskById(id);
    }

    @PostMapping("/create")
    public Task postMethodName(@RequestBody Task newTask) {
        return tasksService.createTask(newTask);
    }

}
