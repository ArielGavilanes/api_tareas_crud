package com.yavirac.api_tareas_crud.tasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yavirac.api_tareas_crud.tasks.model.Task;
import com.yavirac.api_tareas_crud.tasks.service.TasksService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {
    @Autowired
    private TasksService tasksService;

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = tasksService.getAllTasks();
        return ResponseEntity.ok(tasks);

    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Task> findTaskById(@PathVariable Long id) {
        Task task = tasksService.findTaskById(id);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Task> createTask(@RequestBody Task newTask) {
        Task taskCreated = tasksService.createTask(newTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);

    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Task> updateTask(@RequestBody Task taskDetails, @PathVariable Long id) {
        Task updatedTask = tasksService.updateTask(id, taskDetails);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<void> deleteTask(@PathVariable Long id) {
        Task deleteTask = taskService.deleteTask(id);
        ResponseEntity.noContent().build();
    }
}