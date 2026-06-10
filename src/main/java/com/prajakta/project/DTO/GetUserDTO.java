package com.prajakta.project.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserDTO {
    private Long id;
    private String username;

    @Override
    public String toString() {
        return "GetUserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
