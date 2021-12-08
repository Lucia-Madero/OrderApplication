package com.switchfully.orderapplication.service;

import com.switchfully.orderapplication.domain.user.User;
import com.switchfully.orderapplication.service.dto.CreateUserDto;
import com.switchfully.orderapplication.service.dto.UserDto;
import org.springframework.stereotype.Service;
import com.switchfully.orderapplication.repository.UserRepository;
import com.switchfully.orderapplication.service.mapper.UserMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto createUser(CreateUserDto userToCreate) {
        if (userAlreadyExists(userToCreate)){
            throw new IllegalArgumentException("The email address already exists!");
        }
        User newUser = userMapper.mapFromCreateDtoToUser(userToCreate);
        userRepository.save(newUser);
        return userMapper.mapUserToUserDto(newUser);
    }

    public List<UserDto> getAll() {
        return userRepository.getAll().stream()
                .map(userMapper::mapUserToUserDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(UUID id) {
        return userMapper.mapUserToUserDto(userRepository.getById(id));
    }

    public User getUserByUsername(String username) {
        return userRepository.getAll().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst().orElse(null);
    }

    public boolean userAlreadyExists(CreateUserDto createUserDto) {
        return userRepository.getAllEmailAddress().contains(createUserDto.getEmail());
    }
}
