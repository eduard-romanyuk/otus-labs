package com.example.otushw2.service;

import com.example.otushw2.dto.CreateUserDto;
import com.example.otushw2.dto.UpdateUserDto;
import com.example.otushw2.dto.UserDto;
import com.example.otushw2.entity.User;
import com.example.otushw2.mapper.UserMapper;
import com.example.otushw2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto findById(long id) {
        return userMapper.toDto(findUser(id));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto create(CreateUserDto dto) {
        if (userRepository.existsByUsername(dto.getUsername()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already in use");
        if (userRepository.existsByEmail(dto.getEmail()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
        if (userRepository.existsByPhone(dto.getPhone()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Phone already in use");
        User entity = userMapper.toEntity(dto);
        entity = userRepository.save(entity);
        return userMapper.toDto(entity);
    }

    @Override
    public UserDto update(UpdateUserDto dto, long id) {
        User entity = findUser(id);
        userMapper.update(entity, dto);
        entity = userRepository.save(entity);
        return userMapper.toDto(entity);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    private User findUser(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }
}
