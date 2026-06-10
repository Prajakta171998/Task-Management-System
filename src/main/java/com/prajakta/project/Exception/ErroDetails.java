package com.prajakta.project.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErroDetails {
    private LocalDateTime localDateTime;
    private String message;
    private String path;
    private String status;

}
