package com.group_A.MyTodo_App.repository;

import com.group_A.MyTodo_App.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
