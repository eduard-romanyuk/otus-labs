package com.example.otushw2.mapper;

import com.example.otushw2.dto.CreateUserDto;
import com.example.otushw2.dto.UpdateUserDto;
import com.example.otushw2.dto.UserDto;
import com.example.otushw2.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface UserMapper {
    @BeanMapping(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget User entity, UpdateUserDto dto);
    User toEntity(CreateUserDto dto);
    UserDto toDto(User entity);
}
