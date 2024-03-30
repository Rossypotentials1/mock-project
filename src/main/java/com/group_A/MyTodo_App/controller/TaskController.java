package com.group_A.MyTodo_App.controller;

import com.group_A.MyTodo_App.dto.TaskDto;
import com.group_A.MyTodo_App.entity.Task;
import com.group_A.MyTodo_App.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/login")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @GetMapping("/user/{userId}")
    public List<Task> getAllTasksByUserId(@PathVariable Long userId) {
        return taskService.findTasksByUserId(userId);
    }
    @PutMapping("/tasks/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody TaskDto taskUpdateDto){
        return taskService.updateTask(taskId, taskUpdateDto);
    }
}

