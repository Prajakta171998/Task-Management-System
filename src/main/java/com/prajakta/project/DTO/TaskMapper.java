package com.prajakta.project.DTO;

import com.prajakta.project.Entity.Task;
import com.prajakta.project.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface TaskMapper {


    @Mapping(source = "user", target = "getUserDTO")
    TaskDTO toDTO(Task task);

    @Mapping(source = "getUserDTO", target = "user")
    Task toEntity(TaskDTO taskDTO);

}
