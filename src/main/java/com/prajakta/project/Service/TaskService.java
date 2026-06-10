package com.prajakta.project.Service;

import com.prajakta.project.DTO.TaskDTO;
import com.prajakta.project.Entity.Task;
import com.prajakta.project.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {

    public TaskDTO addTask(TaskDTO task);
    public TaskDTO updateTask(TaskDTO task);
    public TaskDTO findTask(Long id);
    public List<TaskDTO> findAllTask();
    public void deleteTask(Long id);

}
