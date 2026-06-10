package com.prajakta.project.DTO;

import com.prajakta.project.Entity.Task;
import com.prajakta.project.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.lang.annotation.Target;

@Mapper(componentModel = "spring")
public interface UserMapper {

        User toEntity(GetUserDTO getUserDTO);

        GetUserDTO toGetDTO(User user);

    }

