package com.yavirac.api_tareas_crud.tasks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yavirac.api_tareas_crud.tasks.model.Tasks;
import com.yavirac.api_tareas_crud.tasks.repository.TasksRepository;


@Service
public class TasksService {
    @Autowired
    private TasksRepository tasksRepository;

    public List<Tasks> getAll() {
        return tasksRepository.findAll();
    }

}
