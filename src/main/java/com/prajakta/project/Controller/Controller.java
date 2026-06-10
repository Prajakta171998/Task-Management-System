package com.prajakta.project.Controller;

import com.prajakta.project.DTO.TaskDTO;
import com.prajakta.project.Service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    TaskServiceImpl taskService;

    @PostMapping("/addTask")
    @PreAuthorize("hasAuthority('TASK_CREATE')")
    public TaskDTO addTask(@RequestBody TaskDTO taskDTO){
        return taskService.addTask(taskDTO);
    }

    @GetMapping("/findtask/{Id}")
    @PreAuthorize("hasAuthority('TASK_VIEW')")
    public TaskDTO findTask(@PathVariable Long Id){
        return taskService.findTask(Id);
    }

    @GetMapping("/findAlltask")
    @PreAuthorize("hasAuthority('TASK_VIEW')")
    public List<TaskDTO> findAllTask(){
        return taskService.findAllTask();
    }

    @PutMapping("/updateTask")
    @PreAuthorize("hasAuthority('TASK_UPDATE')")
    public TaskDTO updateTask(@RequestBody TaskDTO taskDTO){
        return taskService.updateTask(taskDTO);
    }
    @PreAuthorize("hasAuthority('TASK_DELETE')")
    @DeleteMapping("/deleteTask/{Id}")
    public void deleteTask(@PathVariable Long Id){
        taskService.deleteTask(Id);
    }
}
