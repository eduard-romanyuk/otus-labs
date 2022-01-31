package com.example.otushw2.dto;

import lombok.Value;

@Value
public class UpdateUserDto {
    String firstName;
    String lastName;
    String email;
    String phone;
}
