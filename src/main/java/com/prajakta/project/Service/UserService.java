package com.prajakta.project.Service;

import com.prajakta.project.DTO.SaveUserDTO;
import com.prajakta.project.Entity.AuthRequest;
import com.prajakta.project.Entity.User;

public interface UserService {

    public User adddUser(SaveUserDTO saveUserDTO);

    public User addAdminsUser(SaveUserDTO saveUserDTO);
}
