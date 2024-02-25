package com.splitwise.Splitwise.services;

import com.splitwise.Splitwise.dtos.RegisterUserRequestDto;
import com.splitwise.Splitwise.dtos.UserDto;
import com.splitwise.Splitwise.models.User;
import com.splitwise.Splitwise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User registerUser(RegisterUserRequestDto registerUserRequestDto){
        User user = new User();
        user.setEmail(registerUserRequestDto.getEmail());
        user.setName(registerUserRequestDto.getName());
        user.setPassword(registerUserRequestDto.getPassword());
        user.setPhone(registerUserRequestDto.getPhone());

        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
