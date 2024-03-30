package com.group_A.MyTodo_App.service;

import com.group_A.MyTodo_App.dto.TaskDto;
import com.group_A.MyTodo_App.entity.Task;
import com.group_A.MyTodo_App.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface TaskService {

    public List<Task> findTasksByUserId(Long UserId);
    public Task updateTask(Long taskId, TaskDto taskUpdateDto);
}


