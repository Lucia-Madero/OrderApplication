package com.switchfully.orderapplication.service;

import com.switchfully.orderapplication.domain.User;
import com.switchfully.orderapplication.service.dto.CreateUserDto;
import com.switchfully.orderapplication.service.dto.UserDto;
import org.springframework.stereotype.Service;
import com.switchfully.orderapplication.repository.UserRepository;
import com.switchfully.orderapplication.service.mapper.UserMapper;

@Service
public class UserService {

    private UserMapper userMapper;
    private UserRepository userRepository;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto createUser(CreateUserDto userToCreate) {
       User newUser = userMapper.mapFromCreateDtoToUser(userToCreate);
       userRepository.save(newUser);
       return userMapper.mapUserToUserDto(newUser);
    }
}
