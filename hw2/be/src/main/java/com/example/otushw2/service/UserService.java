package com.example.otushw2.service;

import com.example.otushw2.dto.CreateUserDto;
import com.example.otushw2.dto.UpdateUserDto;
import com.example.otushw2.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto findById(long id);
    List<UserDto> findAll();
    UserDto create(CreateUserDto dto);
    UserDto update(UpdateUserDto dto, long id);
    void delete(long id);
}
