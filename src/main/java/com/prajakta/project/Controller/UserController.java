package com.prajakta.project.Controller;

import com.prajakta.project.DTO.SaveUserDTO;
import com.prajakta.project.Entity.AuthRequest;
import com.prajakta.project.Entity.User;
import com.prajakta.project.Repository.UserRepository;
import com.prajakta.project.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userserviceimpl;

    @PostMapping("/signup")
    public User userSignup(@RequestBody SaveUserDTO saveUserDTO) {
    return userserviceimpl.adddUser(saveUserDTO);
    }

    @PostMapping("/adminsignup")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public User adminSignup (@RequestBody SaveUserDTO saveUserDTO){
        return userserviceimpl.addAdminsUser(saveUserDTO);
    }
}
