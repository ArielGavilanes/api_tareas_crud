package com.yavirac.api_tareas_crud.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yavirac.api_tareas_crud.tasks.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}