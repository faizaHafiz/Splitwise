package com.splitwise.Splitwise.controllers;

import com.splitwise.Splitwise.dtos.RegisterUserRequestDto;
import com.splitwise.Splitwise.dtos.UserDto;
import com.splitwise.Splitwise.models.User;
import com.splitwise.Splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("register")
    public ResponseEntity<UserDto> RegisterUser(RegisterUserRequestDto registerUserRequestDto){
        UserDto userDto = new UserDto();
        try{
            User user = userService.registerUser(registerUserRequestDto);
            userDto.setEmail(user.getEmail());
            userDto.setName(user.getName());
            userDto.setStatusmessage("User registered successfully");
            return new ResponseEntity<>(
                    userDto,
                    HttpStatus.OK
            );
        }catch (Exception ex){
            userDto.setStatusmessage("User register failed");
            return new ResponseEntity<>(
                    userDto,
                    HttpStatus.BAD_REQUEST
            );
        }

    }
}
