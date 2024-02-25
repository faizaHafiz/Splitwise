package com.splitwise.Splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDto {
    private String name;
    private String email;
    private String password;
    private String phone;
}
