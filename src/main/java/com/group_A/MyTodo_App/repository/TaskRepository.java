package com.group_A.MyTodo_App.repository;

import com.group_A.MyTodo_App.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId_Id(Long userId);
    Task findByTitle(String title);
    Task findTaskById(Long id);

}

