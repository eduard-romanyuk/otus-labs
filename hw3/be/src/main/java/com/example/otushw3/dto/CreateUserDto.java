package com.example.otushw3.dto;

import lombok.Value;

@Value
public class CreateUserDto {
    String username;
    String firstName;
    String lastName;
    String email;
    String phone;
}
