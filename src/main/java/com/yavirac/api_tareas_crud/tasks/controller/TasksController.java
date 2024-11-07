package com.yavirac.api_tareas_crud.tasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yavirac.api_tareas_crud.tasks.model.Tasks;
import com.yavirac.api_tareas_crud.tasks.service.TasksService;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {
    @Autowired
    private TasksService tasksService;

    @GetMapping("/all")
    public List<Tasks> getAllTasks() {
        return tasksService.getAll();
    }

}
