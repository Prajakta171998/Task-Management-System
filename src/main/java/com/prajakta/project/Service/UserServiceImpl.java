package com.prajakta.project.Service;

import com.prajakta.project.DTO.SaveUserDTO;
import com.prajakta.project.Entity.AuthRequest;
import com.prajakta.project.Entity.User;
import com.prajakta.project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.prajakta.project.Entity.Role.ROLE_ADMIN;
import static com.prajakta.project.Entity.Role.ROLE_USER;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User adddUser(SaveUserDTO saveUserDTO) {
        User user = new User();
        user.setUsername(saveUserDTO.getUsername());
        user.setPassword(passwordEncoder.encode(saveUserDTO.getPassword()));
        user.setRole(ROLE_USER);
      return userRepository.save(user);
    }

    @Override
    public User addAdminsUser(SaveUserDTO saveUserDTO) {
        User  user = new User();
        user.setUsername(saveUserDTO.getUsername());
        user.setPassword(passwordEncoder.encode(saveUserDTO.getPassword()));
        user.setRole(ROLE_ADMIN);
        return userRepository.save(user);
    }


}
