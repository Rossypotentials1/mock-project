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


    public TaskDto createTask(TaskDto taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDeadline(taskDTO.getDeadline());
        task.setPriorityLevel(taskDTO.getPriorityLevel());
        task.setStatus(taskDTO.getStatus());
        Task savedTask = taskRepository.save(task);
        taskDTO.setId(savedTask.getId());
        return taskDTO;
    }

    @Override
    public TaskDto getTaskByTitle(String title) {
        Task task = taskRepository.findByTitle(title);
        if (task != null) {
            TaskDto taskDTO = convertToDTO(task);
            return taskDTO;
        } else {
            return null;
        }
    }

    @Override
    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.findTaskById(id);
        if(task != null){
            TaskDto taskDto = convertToDTO(task);
            return taskDto;
        }else{
            return null;
        }
    }


    private TaskDto convertToDTO(Task task) {
        TaskDto taskDTO = new TaskDto();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setDeadline(task.getDeadline());
        taskDTO.setPriorityLevel(task.getPriorityLevel());
        taskDTO.setStatus(task.getStatus());
        return taskDTO;
    }


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


