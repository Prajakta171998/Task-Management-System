package com.prajakta.project.Entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String description;
    TaskStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
