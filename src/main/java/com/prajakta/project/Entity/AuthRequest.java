package com.prajakta.project.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
public class AuthRequest {
    private String username;
    private String password;
}
