package com.group_A.MyTodo_App.controller;

import com.group_A.MyTodo_App.dto.TaskDto;
import com.group_A.MyTodo_App.entity.Task;
import com.group_A.MyTodo_App.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/login")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @PostMapping("/new_task")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDTO) {
        TaskDto createdTask = taskService.createTask(taskDTO);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }
    @GetMapping("/title/{title}")
    public ResponseEntity<TaskDto> getTaskByTitle(@PathVariable String title) {
        TaskDto taskTitle = taskService.getTaskByTitle(title);
        if (taskTitle != null) {
            return new ResponseEntity<>(taskTitle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id){
        TaskDto taskID = taskService.getTaskById(id);
        if(taskID != null){
            return new ResponseEntity<>(taskID, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/user/{userId}")
    public List<Task> getAllTasksByUserId(@PathVariable Long userId) {
        return taskService.findTasksByUserId(userId);
    }
    @PutMapping("/tasks/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody TaskDto taskUpdateDto){
        return taskService.updateTask(taskId, taskUpdateDto);
    }
}

