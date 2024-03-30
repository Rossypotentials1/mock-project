package com.group_A.MyTodo_App.service.impl;

import com.group_A.MyTodo_App.dto.TaskDto;
import com.group_A.MyTodo_App.entity.Task;
import com.group_A.MyTodo_App.exceptions.TaskNotFoundException;
import com.group_A.MyTodo_App.repository.TaskRepository;
import com.group_A.MyTodo_App.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    @Override
    public List<Task> findTasksByUserId(Long userId) {
        return taskRepository.findByUserId_Id(userId);
    }

    @Override
    public Task updateTask(Long taskId, TaskDto taskUpdateDto) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id " + taskId));
        task.setTitle(taskUpdateDto.getTitle());
        task.setDescription(taskUpdateDto.getDescription());
        task.setDeadline(taskUpdateDto.getDeadline());
        task.setPriorityLevel(taskUpdateDto.getPriorityLevel());
        task.setStatus(taskUpdateDto.getStatus());

        return taskRepository.save(task);
    }
}


