package com.prajakta.project.Service;

import com.prajakta.project.DTO.GetUserDTO;
import com.prajakta.project.DTO.TaskDTO;
import com.prajakta.project.DTO.TaskMapper;
import com.prajakta.project.DTO.UserMapper;
import com.prajakta.project.Entity.Task;
import com.prajakta.project.Entity.User;
import com.prajakta.project.Exception.TaskNotFoundException;
import com.prajakta.project.Repository.TaskRepository;
import com.prajakta.project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepository userRepository;

    @Override
    public TaskDTO addTask(TaskDTO task) {
    Task task1= taskMapper.toEntity(task);
    Task savedtask = taskRepository.save(task1);
    return taskMapper.toDTO(savedtask);
    }

    @Override
    public TaskDTO updateTask(TaskDTO task) {
        Task DBTask = taskRepository.findById(task.getId()).orElseThrow(() -> new TaskNotFoundException("Task " + task.getId() + " does not exist"));
        DBTask.setTitle(task.getTitle());
        User user = userRepository.findById(task.getGetUserDTO().getId()).get();
        DBTask.setUser(user);
        DBTask.setDescription(task.getDescription());
        DBTask.setStatus(task.getStatus());
        return taskMapper.toDTO(taskRepository.save(DBTask));
    }

    @Override
    public TaskDTO findTask(Long id) {
    Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task " + id + " does not exist"));
    return taskMapper.toDTO(task);
    }

    @Override
    public List<TaskDTO> findAllTask() {
        List<Task> listTask = taskRepository.findAll();

        List<TaskDTO> mappedList = listTask.stream()
                .map(e ->taskMapper.toDTO(e))
                .collect(Collectors.toList());
    return mappedList;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);

    }
}
