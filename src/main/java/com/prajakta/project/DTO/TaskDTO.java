package com.prajakta.project.DTO;

import com.prajakta.project.Entity.TaskStatus;
import com.prajakta.project.Entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    Long id;
    String title;
    String description;
    TaskStatus status;
    GetUserDTO getUserDTO;


}
